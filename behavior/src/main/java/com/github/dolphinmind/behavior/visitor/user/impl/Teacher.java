package com.github.dolphinmind.behavior.visitor.user.impl;

import com.github.dolphinmind.behavior.visitor.user.User;
import com.github.dolphinmind.behavior.visitor.visitor.IVisitor;

import java.math.BigDecimal;

/**
 * @author dolphinmind
 * @ClassName Teacher
 * @description 老师
 * @date 2024/8/1
 */

public class Teacher extends User {

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * @description 获取学生通过考试比例
     * @return double
     * @date 2024/8/1
     */
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
