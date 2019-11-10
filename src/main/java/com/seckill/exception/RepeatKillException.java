package com.seckill.exception;

/**
 * RepeatException
 *
 * @author Joseph
 * @version 1.0
 * 2019/11/8 14:35
 **/
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
