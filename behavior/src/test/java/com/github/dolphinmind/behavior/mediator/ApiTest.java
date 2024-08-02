package com.github.dolphinmind.behavior.mediator;

import com.alibaba.fastjson.JSON;
import com.github.dolphinmind.behavior.mediator.mediator.SqlSession;
import com.github.dolphinmind.behavior.mediator.mediator.SqlSessionFactory;
import com.github.dolphinmind.behavior.mediator.mediator.impl.SqlSessionFactoryBuilder;
import com.github.dolphinmind.behavior.mediator.mediator.support.Resources;
import com.github.dolphinmind.behavior.mediator.po.Award;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @author dolphinmind
 * @ClassName ApiTest
 * @description
 * @date 2024/8/2
 */

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private String resource = "mybatis-config-datasource.xml";
    private Reader reader;

    @Test
    public void test_queryAwardInfoByAwardId() {
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlMapper.openSession();

            try {
                Award award = session.selectOne("com.github.dolphinmind.behavior.mediator.dao.IAward.queryAwardInfoByAwardId");
                logger.info("测试结果：{}", JSON.toJSONString(award));
            } finally {
                session.close();
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
