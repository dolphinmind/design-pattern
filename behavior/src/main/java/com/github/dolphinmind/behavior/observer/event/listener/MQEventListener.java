package com.github.dolphinmind.behavior.observer.event.listener;

import com.github.dolphinmind.behavior.observer.po.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dolphinmind
 * @ClassName MQEventListener
 * @description
 * @date 2024/8/1
 */

public class MQEventListener implements EventListener{
    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("记录用户 {} 摇号结果(MQ)：{}", result.getUId(), result.getMsg());
    }
}
