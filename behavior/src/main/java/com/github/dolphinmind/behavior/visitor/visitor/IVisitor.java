package com.github.dolphinmind.behavior.visitor.visitor;

import com.github.dolphinmind.behavior.visitor.user.impl.Student;
import com.github.dolphinmind.behavior.visitor.user.impl.Teacher;

/**
 * @author dolphinmind
 * @InterfaceName IVisitor
 * @description
 * @date 2024/8/1
 */

public interface IVisitor {

    // 访问学生信息
    void visit(Student student);

    // 访问老师信息
    void visit(Teacher teacher);

}
