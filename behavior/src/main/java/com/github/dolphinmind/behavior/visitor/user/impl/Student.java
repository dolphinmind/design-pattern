package com.github.dolphinmind.behavior.visitor.user.impl;

import com.github.dolphinmind.behavior.visitor.user.User;
import com.github.dolphinmind.behavior.visitor.visitor.IVisitor;

/**
 * @author dolphinmind
 * @ClassName Student
 * @description 学生
 * @date 2024/8/1
 */

public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }
}
