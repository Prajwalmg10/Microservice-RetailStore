package com.online.retailStore.uiResponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class UiError<T> extends UIResponse<T> implements Serializable {
    private static final long serialVersionUID = 4311696013200578760L;
    @Getter
    @Setter
    private String messageCode;
    private String message;
    private Integer status;
    @Getter
    private String stackTrace;

    /**
     * @param t
     */
    public UiError(T t) {
        super(t);
    }

    /**
     * No arg constructor
     */
    public UiError() {
        super();
    }

    @Override
    public String toString() {
        return "UIErrorMessage [messageCode=" + messageCode + ", message=" + message + ", stackTrace=" + stackTrace
                + "]";
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

}