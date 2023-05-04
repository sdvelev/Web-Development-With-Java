package bg.fmi.course.wdwj.dealership.controller.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({ApiBadRequest.class})
    public ResponseEntity<?> handleBadRequest(ApiBadRequest exception) {

        return ResponseEntity.badRequest().body(exception.getMessage() + " from advice");
    }
}
