package com.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author prabh
 * @implNote This is a controller advice that handles all the exceptions thrown in the application.
 * Instead of handling exceptions at multiple places within the app, we handle all of them here and present
 * a meaningful response to the end user.
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     * @implNote The method handles is an override to invalid media type exception.
     */
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
        ApiError apiError = new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, builder.substring(0, builder.length() - 2), ex);
        log.error(apiError.toString());
        return buildResponseEntity(apiError);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     * @implNote The method handles is an override to invalid or malformed message received.
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        String error = "Malformed JSON request";
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, error, ex);
        log.error(apiError.toString());
        return buildResponseEntity(apiError);
    }


    /**
     *
     * @param ex
     * @return
     * @implNote This is a custom Exception class for invalid strings
     */
    @ExceptionHandler(InvalidStringException.class)
    protected ResponseEntity<Object> handleInvalidString(InvalidStringException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
        log.error(apiError.toString());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
