package com.github.dolphinmind.behavior.observer.service;

import com.github.dolphinmind.behavior.observer.event.EventManager;
import com.github.dolphinmind.behavior.observer.event.listener.EventType;
import com.github.dolphinmind.behavior.observer.event.listener.MQEventListener;
import com.github.dolphinmind.behavior.observer.event.listener.MessageEventListener;
import com.github.dolphinmind.behavior.observer.po.LotteryResult;

/**
 * @author dolphinmind
 * @ClassName LotteryService
 * @description
 * @date 2024/8/1
 */

public abstract class LotteryService {

    private EventManager eventManager;

    public LotteryService() {
        eventManager = new EventManager(EventType.MQ,EventType.Message);
        eventManager.subscribe(EventType.MQ,new MQEventListener());
        eventManager.subscribe(EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        eventManager.notify(EventType.MQ,lotteryResult);
        eventManager.notify(EventType.Message,lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);
}
