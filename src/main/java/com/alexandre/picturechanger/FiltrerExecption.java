package com.alexandre.picturechanger;

public class FiltrerExecption extends Exception {

    public FiltrerExecption() {
    }

    public FiltrerExecption(String message) {
        super(message);

    }

    public FiltrerExecption(String message, Throwable cause) {
        super(message, cause);
    }
}
