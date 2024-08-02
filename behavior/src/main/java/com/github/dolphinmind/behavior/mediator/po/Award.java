package com.github.dolphinmind.behavior.mediator.po;

import lombok.Data;

import java.util.Date;

/**
 * @author dolphinmind
 * @ClassName Award
 * @description
 * @date 2024/8/2
 */

@Data
public class Award {

    private Long id;
    private Long award_id;
    private String award_key;
    private String award_config;
    private String award_desc;
    private Date create_time;
    private Date update_time;


}
