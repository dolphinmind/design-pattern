package com.github.dolphinmind.behavior.mediator.mediator.support;

import lombok.Data;

import java.util.Map;

/**
 * @author dolphinmind
 * @ClassName XNode
 * @description
 * @date 2024/8/2
 */

@Data
public class XNode {

    private String namespace;
    private String id;
    private String parameterType;
    private String resultType;
    private String sql;
    private Map<Integer, String> parameter;

}
