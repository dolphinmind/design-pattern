package com.github.dolphinmind.behavior.visitor.visitor.impl;

import com.github.dolphinmind.behavior.visitor.user.impl.Student;
import com.github.dolphinmind.behavior.visitor.user.impl.Teacher;
import com.github.dolphinmind.behavior.visitor.visitor.IVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author dolphinmind
 * @ClassName Parent
 * @description 家长
 * @date 2024/8/1
 */

public class Parent implements IVisitor {

    private Logger logger = LoggerFactory.getLogger(Parent.class);

    @Override
    public void visit(Student student) {
        logger.info("学生信息 姓名：{} 班级：{} 排名：{}", student.name, student.clazz, student.ranking());
    }

    @Override
    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{} 班级：{} 级别：{}", teacher.name, teacher.clazz, teacher.identity);
    }
}
