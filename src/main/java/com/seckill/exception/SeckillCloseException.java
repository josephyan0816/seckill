package com.seckill.exception;

/**
 * SeckillCloseException
 *
 * @author Joseph
 * @version 1.0
 * 2019/11/8 14:37
 **/
public class SeckillCloseException extends SeckillException{

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
