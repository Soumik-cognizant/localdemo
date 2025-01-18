package com.cts.examportal.helper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	 @ExceptionHandler(UserNotFoundException.class)
	 public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	  }

	 @ExceptionHandler(UserFoundException.class)
	 public ResponseEntity<?> handleUserFoundException(UserFoundException ex, WebRequest request) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
	  }
	
	@ExceptionHandler(UserDisabledException.class)
    public ResponseEntity<?> handleUserDisabledException(UserDisabledException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<?> handleInvalidCredentialsException(InvalidCredentialsException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
