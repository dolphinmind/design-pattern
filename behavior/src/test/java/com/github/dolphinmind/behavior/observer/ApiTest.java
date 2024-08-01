package com.github.dolphinmind.behavior.observer;

import com.alibaba.fastjson.JSON;
import com.github.dolphinmind.behavior.observer.po.LotteryResult;
import com.github.dolphinmind.behavior.observer.service.LotteryService;
import com.github.dolphinmind.behavior.observer.service.impl.LotteryServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dolphinmind
 * @ClassName ApiTest
 * @description
 * @date 2024/8/1
 */

public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test() {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("2765789109876");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }
}
