package com.github.dolphinmind.behavior.observer.service.impl;


import com.github.dolphinmind.behavior.observer.po.LotteryResult;
import com.github.dolphinmind.behavior.observer.service.LotteryService;
import com.github.dolphinmind.behavior.observer.service.MinibusTargetService;

import java.util.Date;

/**
 * @author dolphinmind
 * @ClassName LotteryServiceImpl
 * @description
 * @date 2024/8/1
 */

public class LotteryServiceImpl extends LotteryService {

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {

        // 摇号
        String lottery = minibusTargetService.lottery(uId);

        // 结果
        return new LotteryResult(uId, lottery, new Date());
    }
}
