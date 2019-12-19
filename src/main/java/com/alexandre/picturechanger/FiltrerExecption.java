package com.alexandre.picturechanger;

/**
 *
 */
public class FiltrerExecption extends Exception {
    /**
     *
     */
    public FiltrerExecption() {
    }

    /**
     *
     * @param message Message for the Exception
     */
    public FiltrerExecption(String message) {
        super(message);

    }

    /**
     *
     * @param message Message for Exception
     * @param cause The cause for the Exception
     */
    public FiltrerExecption(String message, Throwable cause) {
        super(message, cause);
    }
}
