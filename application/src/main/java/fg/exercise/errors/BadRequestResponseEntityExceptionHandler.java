package fg.exercise.errors;

import fg.exercise.exceptions.InvalidTimestampException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class BadRequestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ InvalidTimestampException.class })
    public ResponseEntity<Object> handleBadRequest(final InvalidTimestampException ex, final WebRequest request) {
        return handleExceptionInternal(ex, ex.toDto(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
