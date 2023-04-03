package com.bilgeadam.exception;

import lombok.Getter;
//özelleştirdiğimiz bir hata sınıfı
//hataları ortama fırlatır
@Getter
public class RentaCarException extends RuntimeException{
    private final ErrorType errorType;
    public RentaCarException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }
    public RentaCarException(ErrorType errorType, String message){
        super(message);
        this.errorType=errorType;
    }

}
