package com.seckill.exception;

/**
 * SeckillException
 *
 * @author Joseph
 * @version 1.0
 * 2019/11/8 14:38
 **/
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
