package br.com.soul_academy.infra.exception;

public class DataAlreadyRegisteredException extends RuntimeException {
    public DataAlreadyRegisteredException(String message) {
        super(message);
    }
}
