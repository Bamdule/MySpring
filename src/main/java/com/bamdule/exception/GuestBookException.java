package com.bamdule.exception;

/**
 *
 * @author MW
 */
public class GuestBookException extends RuntimeException{

    public GuestBookException() {
        super("GuestBook Dao Exception");
    }
    
    public GuestBookException(String msg){
        super(msg);
    }
    
}
