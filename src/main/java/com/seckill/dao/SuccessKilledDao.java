package com.seckill.dao;

import com.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * SuccessKilledDao
 *
 * @author Joseph
 * @version 1.0
 * 2019/11/7 19:33
 **/
@Repository
public interface SuccessKilledDao {

    //插入购买明细，可过滤重复
    int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);


    //根据id查询successkilled并携带秒杀产品对象实体
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
