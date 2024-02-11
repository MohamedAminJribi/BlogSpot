package com.example.sparkit.fr.BlogSpot.Exeption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpCustomException extends  RuntimeException{
    private int errorCode;
    private String errorMessage;
    private ErrorResponse errorResponse;

    public HttpCustomException(String errorMessage){
        super(errorMessage);
        this.errorMessage=errorMessage;
    }

    public HttpCustomException(String errorMessage, int errorCode){
        super(errorMessage);
        this.errorMessage=errorMessage;
        this.errorCode=errorCode;
    }

    public HttpCustomException(String errorMessage, int errorCode, ErrorResponse errorResponse){
        super(errorMessage);
        this.errorMessage=errorMessage;
        this.errorCode=errorCode;
        this.errorResponse=errorResponse;
    }
}
