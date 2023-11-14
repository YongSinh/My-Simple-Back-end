package co.istad.s4mbanking.exception;

import co.istad.s4mbanking.base.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MainException {

    @ExceptionHandler(Exception.class)
    public BaseError<?> handleMainException(Exception e) {
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Something went wrong, please check in error detail!")
                .timestamp(LocalDateTime.now())
                .errors(e.getCause().getMessage())
                .build();
    }

}
