package com.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * Seckill
 *
 * @author Joseph
 * @version 1.0
 * 2019/11/7 19:14
 **/
@Data
public class Seckill {

    private long seckillId;

    private String name;
    private  int number;
    private Date startTime;
    private Date endTime;
    private Date createTime;
}
