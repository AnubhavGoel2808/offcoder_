package com.example.offcodercyberquest.environments;

/*
*
*
* A special exception made to deal with tle error as it may abort abruptly it can now show an error.
*
*
* */
public class TimeLimitExceededException extends Exception{
    public TimeLimitExceededException() {
        super();
    }

    public TimeLimitExceededException(String message) {
        super(message);
    }

    public TimeLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeLimitExceededException(Throwable cause) {
        super(cause);
    }

    public TimeLimitExceededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
