package com.github.dolphinmind.behavior.mediator.mediator.impl;

import com.github.dolphinmind.behavior.mediator.mediator.support.Configuration;
import com.github.dolphinmind.behavior.mediator.mediator.support.Resources;
import com.github.dolphinmind.behavior.mediator.mediator.support.XNode;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dolphinmind
 * @ClassName SqlSessionFactoryBuilder
 * @description
 * @date 2024/8/2
 */

public class SqlSessionFactoryBuilder {

    /**
     * 构建实例化元素
     * @param reader
     * @return
     */
    public DefaultSqlSessionFactory build(Reader reader) {
        // 用于解析XML文件
        SAXReader saxReader = new SAXReader();

        try {
            // 为了包装在不联网的时候一样可以解析XML，否则会需要从互联网获取dtd文件
            saxReader.setEntityResolver(new XMLMapperEntityResolver());
            Document document = saxReader.read(new InputSource(reader));

            // TODO parseConfiguration
            Configuration configuration = parseConfiguration(document.getRootElement());

            return new DefaultSqlSessionFactory(configuration);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析配置，是对xml中的元素进行获取
     * dataSource:数据库的链接信息
     * mappers: 数据库操作语句的解析
     * @param root
     * @return
     */
    private Configuration parseConfiguration(Element root) {
        Configuration configuration = new Configuration();

        // 设置数据源
        configuration.setDataSource(dataSource(root.selectNodes("//dataSource")));
        // 设置数据库连接
        configuration.setConnection(connection(configuration.dataSource));
        // 设置mappers
        configuration.setMapperElement(mapperElement(root.selectNodes("mappers")));

        return configuration;
    }

    /**
     * 获取数据库配置
     * @param list
     * @return
     */
    private Map<String, String> dataSource(List<Element> list) {
        Map<String, String> dataSource = new HashMap<>(4);
        Element element = list.get(0);
        List content = element.content();
        for (Object o : content) {
            Element e = (Element) o;
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            dataSource.put(name, value);
        }
        return dataSource;
    }

    /**
     * 链接数据库
     * @param dataSource
     * @return
     */
    private Connection connection(Map<String, String> dataSource) {
        try {
            Class.forName(dataSource.get("driver"));
            return DriverManager.getConnection(dataSource.get("url"),  dataSource.get("username"), dataSource.get("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 解析sql语句，解析完成后的sql语句会有一个名称和sql的映射关系，
     * 当我们进行数据库操作的时候，这个组件就可以通过映射关系获取到对应的sql语句进行操作
     * @param list
     * @return
     */
    private Map<String, XNode> mapperElement(List<Element> list) {
        Map<String, XNode> map = new HashMap<>();

        Element element = list.get(0);
        List content = element.content();

        for (Object o : content) {
            Element e = (Element) o;
            String resource = e.attributeValue("resource");

            try {
                Reader reader = Resources.getResourceAsReader(resource);
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(new InputSource(reader));
                Element root = document.getRootElement();

                // 命名空间
                String namespace = root.attributeValue("namespace");

                // SELECT
                List<Element> selectNodes = root.selectNodes("select");
                for (Element node : selectNodes) {
                    String id = node.attributeValue("id");
                    String parameterType = node.attributeValue("parameterType");
                    String resultType = node.attributeValue("resultType");
                    String sql = node.getText();

                    // ? 匹配
                    Map<Integer, String> parameter = new HashMap<>();
                    Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                    Matcher matcher = pattern.matcher(sql);
                    for (int i = 1; matcher.find(); i++) {
                        String g1 = matcher.group(1);
                        String g2 = matcher.group(2);
                        parameter.put(i, g2);
                        sql = sql.replace(g1, "?");
                    }

                    XNode xNode = new XNode();
                    xNode.setNamespace(namespace);
                    xNode.setId(id);
                    xNode.setParameterType(parameterType);
                    xNode.setResultType(resultType);
                    xNode.setSql(sql);
                    xNode.setParameter(parameter);

                    map.put(namespace + "." + id, xNode);
                }
            } catch (IOException | DocumentException ex) {
                throw new RuntimeException(ex);
            }
        }

        return map;
    }
}
