package ua.beauty.calendar.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler(Exception.class)
//    public CreateEventResponse globleExcpetionHandler(Exception ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//        return new CreateEventResponse("error",ex.getMessage());
//    }

//    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
//    public CreateEventResponse invalidParam(InvalidDataAccessApiUsageException ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//        return new CreateEventResponse("error",errorDetails.getMessage());
//    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public CreateEventResponse constraintViolationException(HttpServletResponse response) throws IOException {
//        return new CreateEventResponse("error","error");
//    }

//    @Override
//    protected ResponseEntity<Object>
//    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                 HttpHeaders headers,
//                                 HttpStatus status, WebRequest request) {
//
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", new Date());
//        body.put("status", status.value());
//
//        //Get all fields errors
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(x -> x.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        body.put("errors", errors);
//
//        return new ResponseEntity<>(body, headers, status);
//
//    }
}