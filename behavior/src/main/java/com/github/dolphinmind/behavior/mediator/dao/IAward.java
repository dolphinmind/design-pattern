package com.github.dolphinmind.behavior.mediator.dao;

import com.github.dolphinmind.behavior.mediator.po.Award;

/**
 * @author dolphinmind
 * @InterfaceName IAward
 * @description
 * @date 2024/8/2
 */

public interface IAward {

    Award queryAwardInfoByAwardId(Integer awardId);

}
