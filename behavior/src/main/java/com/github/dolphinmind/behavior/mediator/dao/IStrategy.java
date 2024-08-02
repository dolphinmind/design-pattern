package com.github.dolphinmind.behavior.mediator.dao;

import com.github.dolphinmind.behavior.mediator.po.Strategy;

/**
 * @author dolphinmind
 * @InterfaceName IStrategy
 * @description
 * @date 2024/8/2
 */

public interface IStrategy {

    Strategy queryStrategyInfoByStrategyId(Long strategyId);

}
