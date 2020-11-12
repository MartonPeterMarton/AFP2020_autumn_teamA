package hu.uni.eku.tzs.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class AzonositoAlreadyExistsException extends Exception {

    public AzonositoAlreadyExistsException() {
    }

    public AzonositoAlreadyExistsException(String message) {
        super(message);
    }

    public AzonositoAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AzonositoAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public AzonositoAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
