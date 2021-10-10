package ru.inovus.mimimetr.exception;

public class MimimetrException extends RuntimeException {

    public MimimetrException(String message) {
        super(message);
    }

    public MimimetrException(String msgTemplate, Object[] args) {
        super(String.format(msgTemplate, args));
    }

    public MimimetrException(String message, Exception e) {
        super(message, e);
    }
}