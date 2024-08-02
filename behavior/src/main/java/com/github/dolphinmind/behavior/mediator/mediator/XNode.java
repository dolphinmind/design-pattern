package com.github.dolphinmind.behavior.mediator.mediator;

import java.util.Map;

/**
 * @author dolphinmind
 * @ClassName XNode
 * @description
 * @date 2024/8/2
 */

public class XNode {

    private String namespace;
    private String id;
    private String parameterType;
    private String resultType;
    private String sql;

    public Map<Integer, String> getParameter() {
        return parameter;
    }

    public void setParameter(Map<Integer, String> parameter) {
        this.parameter = parameter;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    private Map<Integer, String> parameter;
}
