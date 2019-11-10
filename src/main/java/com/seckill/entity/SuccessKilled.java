package com.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * SuccessKilled
 *
 * @author Joseph
 * @version 1.0
 * 2019/11/7 19:21
 **/
@Data
public class SuccessKilled {

    private long seckillId;
    private long userPhone;
    private short state;
    private Date createTime;

    private Seckill seckill;
}
