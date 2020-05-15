package com.zhouning.exception;

/**
 * @author zhouning
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("用户不存在");
    }
}
