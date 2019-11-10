package com.seckill.dao;

import com.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * SeckillDao
 *
 * @author Joseph
 * @version 1.0
 * 2019/11/7 19:27
 **/
@Repository
public interface SeckillDao {

    //减库存
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);


    //根据id查询秒杀对象
    Seckill queryById(long seckillId);


    //根据偏移量查询秒杀商品列表
    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);




    void killByProcedure(Map<String,Object> paramMap);




}
