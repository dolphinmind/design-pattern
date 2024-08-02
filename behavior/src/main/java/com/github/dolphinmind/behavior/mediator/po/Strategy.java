package com.github.dolphinmind.behavior.mediator.po;

import lombok.Data;

import java.util.Date;

/**
 * @author dolphinmind
 * @ClassName Strategy
 * @description
 * @date 2024/8/2
 */

@Data
public class Strategy {

    private Long id;
    private Long strategy_id;
    private String strategy_desc;
    private String rule_models;
    private Date create_time;
    private Date update_time;

}
