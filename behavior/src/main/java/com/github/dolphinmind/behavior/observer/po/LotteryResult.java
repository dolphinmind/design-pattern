package com.github.dolphinmind.behavior.observer.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author dolphinmind
 * @ClassName LotteryResult
 * @description
 * @date 2024/8/1
 */

@Data
@NoArgsConstructor
public class LotteryResult {
    // 用户ID
    private String uId;
    // 摇号信息
    private String msg;
    // 业务时间
    private Date dateTime;


    public LotteryResult(String uId, String msg, Date dateTime) {
        this.uId = uId;
        this.msg = msg;
        this.dateTime = dateTime;
    }


}
