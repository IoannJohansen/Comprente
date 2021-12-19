package com.sachishin.comprente.Exception;

public class DuplicateUserException extends Exception{
    public DuplicateUserException(){
    }

    public DuplicateUserException(String message){
        super(message);
    }
}
