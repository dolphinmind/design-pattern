package com.github.dolphinmind.behavior.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author dolphinmind
 * @ClassName JDBCUtil
 * @description
 * @date 2024/8/2
 */

public class JDBCUtil {

    private static Logger logger = LoggerFactory.getLogger(JDBCUtil.class);

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/big_market?useUnicode=true&characterEncoding=utf8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&useSSL=true";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        // 1. 加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // 3. 操作数据
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT award_id, award_key, award_config, award_desc, create_time, update_time FROM award");

        // 4. 如果有数据 resultSet.next() 返回 true
        while (resultSet.next()) {
            logger.info("award_id: {}, award_key: {}, award_config: {}, award_desc: {}, create_time: {}, update_time: {}",
                    resultSet.getString("award_id"),
                    resultSet.getString("award_key"),
                    resultSet.getString("award_config"),
                    resultSet.getString("award_desc"),
                    resultSet.getString("create_time"),
                    resultSet.getString("update_time"));
        }
    }

}
