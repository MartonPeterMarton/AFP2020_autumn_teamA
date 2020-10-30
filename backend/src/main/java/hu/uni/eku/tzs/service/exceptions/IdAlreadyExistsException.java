package hu.uni.eku.tzs.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class IdAlreadyExistsException extends Exception {

    public IdAlreadyExistsException() {
    }

    public IdAlreadyExistsException(String message) {
        super(message);
    }

    public IdAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public IdAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
