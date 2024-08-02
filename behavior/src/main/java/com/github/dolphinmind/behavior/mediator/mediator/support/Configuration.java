package com.github.dolphinmind.behavior.mediator.mediator.support;

import java.sql.Connection;
import java.util.Map;

/**
 * @author dolphinmind
 * @ClassName Configuration
 * @description
 * @date 2024/8/2
 */

public class Configuration {

    public Connection connection;
    public Map<String, String> dataSource;
    public Map<String, XNode> mapperElement;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setDataSource(Map<String, String> dataSource) {
        this.dataSource = dataSource;
    }

    public void setMapperElement(Map<String, XNode> mapperElement) {
        this.mapperElement = mapperElement;
    }
}
