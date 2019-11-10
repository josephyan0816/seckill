package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SeckillService
 *
 * @author Joseph
 * @version 1.0
 * 2019/11/8 14:14
 **/
//三个方面：方法定义粒度，参数，返回类型（return 类型/异常)

//@Service
public interface SeckillService {

    //查询所有秒杀记录
    List<Seckill> getSeckillList();

    //查询单个秒杀
    Seckill getById(long seckillId);

    //秒杀开启时输出秒杀接口,否则输出系统时间和秒杀时间
    Exposer exportSeckillUrl(long seckillId);


    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;


    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);


}
