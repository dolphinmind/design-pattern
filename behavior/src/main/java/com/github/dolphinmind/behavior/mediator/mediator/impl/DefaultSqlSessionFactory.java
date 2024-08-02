package com.github.dolphinmind.behavior.mediator.mediator.impl;

import com.github.dolphinmind.behavior.mediator.mediator.SqlSession;
import com.github.dolphinmind.behavior.mediator.mediator.SqlSessionFactory;
import com.github.dolphinmind.behavior.mediator.mediator.support.Configuration;


/**
 * @author dolphinmind
 * @ClassName DefaultSqlSessionFactory
 * @description
 * @date 2024/8/2
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration.connection, configuration.mapperElement);
    }
}
