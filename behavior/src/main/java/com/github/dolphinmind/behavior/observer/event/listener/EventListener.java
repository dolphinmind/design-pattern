package com.github.dolphinmind.behavior.observer.event.listener;

import com.github.dolphinmind.behavior.observer.po.LotteryResult;

/**
 * @author dolphinmind
 * @InterfaceName EventListener
 * @description
 * @date 2024/8/1
 */

public interface EventListener {

    void doEvent(LotteryResult result);

}
