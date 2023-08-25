package vietnam.com.football_system.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import vietnam.com.football_system.dto.ErrorDto;
import vietnam.com.football_system.exception.AppException;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException appException){
        return ResponseEntity
                .status(appException.getHttpStatus())
                .body(new ErrorDto(appException.getMessage()));
    }
}
