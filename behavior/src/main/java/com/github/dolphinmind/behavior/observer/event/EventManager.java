package com.github.dolphinmind.behavior.observer.event;

import com.github.dolphinmind.behavior.observer.event.listener.EventListener;
import com.github.dolphinmind.behavior.observer.event.listener.EventType;
import com.github.dolphinmind.behavior.observer.po.LotteryResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dolphinmind
 * @ClassName EventManager
 * @description
 * @date 2024/8/1
 */

public class EventManager {

    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    public EventManager(Enum<EventType>... operations) {
        for (Enum<EventType> operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    /**
     * 订阅
     * @param eventType
     * @param listener
     */
    public void subscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    /**
     * 取消订阅
     * @param eventType
     * @param listener
     */
    public void unsubscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     * 通知
     * @param eventType
     * @param result
     */
    public void notify(Enum<EventType> eventType, LotteryResult result) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.doEvent(result);
        }
    }
}
