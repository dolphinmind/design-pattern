package com.github.dolphinmind.behavior.observer.service;

import com.github.dolphinmind.behavior.observer.po.LotteryResult;

/**
 * @author dolphinmind
 * @InterfaceName LotteryService
 * @description
 * @date 2024/8/1
 */

public interface LotteryService {

    LotteryResult doDraw(String uId);

}
