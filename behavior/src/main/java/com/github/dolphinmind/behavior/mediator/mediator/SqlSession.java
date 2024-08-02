package com.github.dolphinmind.behavior.mediator.mediator;

import java.util.List;

/**
 * @author dolphinmind
 * @InterfaceName SqlSession
 * @description
 * @date 2024/8/2
 */

public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement, Object parameter);

    void close();
}
