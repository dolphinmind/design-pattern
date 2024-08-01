package com.github.dolphinmind.behavior.visitor;

import com.github.dolphinmind.behavior.visitor.visitor.impl.Parent;
import com.github.dolphinmind.behavior.visitor.visitor.impl.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

/**
 * @author dolphinmind
 * @ClassName ApiTest
 * @description
 * @date 2024/8/1
 */

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void test_visitor()
    {
        DataView dataView = new DataView();

        logger.info("\r\n家长视角访问：");
        dataView.show(new Parent());     // 家长

        logger.info("\r\n校长视角访问：");
        dataView.show(new Principal());  // 校长
    }
}
