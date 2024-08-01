package com.github.dolphinmind.behavior.observer.event.listener;

import com.github.dolphinmind.behavior.observer.po.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dolphinmind
 * @ClassName MessageEventListener
 * @description
 * @date 2024/8/1
 */

public class MessageEventListener implements EventListener{

    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);
    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给用户 {} 发送短信通知(短信)：{}", result.getUId(), result.getMsg());
    }
}
