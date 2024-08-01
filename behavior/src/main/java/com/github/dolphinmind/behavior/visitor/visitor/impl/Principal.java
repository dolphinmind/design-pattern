package com.github.dolphinmind.behavior.visitor.visitor.impl;

import com.github.dolphinmind.behavior.visitor.user.impl.Student;
import com.github.dolphinmind.behavior.visitor.user.impl.Teacher;
import com.github.dolphinmind.behavior.visitor.visitor.IVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author dolphinmind
 * @ClassName Principal
 * @description
 * @date 2024/8/1
 */

public class Principal implements IVisitor {

    private Logger logger = LoggerFactory.getLogger(Principal.class);
    @Override
    public void visit(Student student) {
        logger.info("学生信息 姓名：{} 班级：{}", student.name, student.clazz);
    }

    @Override
    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{} 班级：{} 升学率：{}", teacher.name, teacher.clazz, teacher.entranceRatio());
    }
}
