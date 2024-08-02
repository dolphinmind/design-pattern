package com.github.dolphinmind.behavior.mediator.mediator;

/**
 * @author dolphinmind
 * @InterfaceName SqlSessionFactory
 * @description
 * @date 2024/8/2
 */

public interface SqlSessionFactory {

    SqlSession openSession();

}
