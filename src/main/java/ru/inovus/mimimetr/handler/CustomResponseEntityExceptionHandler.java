package ru.inovus.mimimetr.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.inovus.mimimetr.exception.CatNotFoundException;
import ru.inovus.mimimetr.exception.MimimetrException;
import ru.inovus.mimimetr.exception.UserNotFoundException;
import ru.inovus.mimimetr.model.dto.ErrorDetailsDto;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CatNotFoundException.class, UserNotFoundException.class})
    @ResponseBody
    public ResponseEntity<Object> handleNotFoundException(
            MimimetrException ex,
            WebRequest request
    ) {
        log.error(ex.getMessage());
        ErrorDetailsDto error = new ErrorDetailsDto(
                request,
                HttpStatus.NOT_FOUND,
                ex.getLocalizedMessage()
        );
        return handleExceptionInternal(ex, error, HttpHeaders.EMPTY, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException ex,
            WebRequest request
    ) {
        log.error(ex.getMessage());
        ErrorDetailsDto error = new ErrorDetailsDto(
                request,
                HttpStatus.BAD_REQUEST,
                ex.getLocalizedMessage()
        );
        return handleExceptionInternal(ex, error, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(MimimetrException.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(
            MimimetrException ex,
            WebRequest request
    ) {
        log.error(ex.getMessage());
        ErrorDetailsDto error = new ErrorDetailsDto(
                request,
                HttpStatus.BAD_REQUEST,
                ex.getLocalizedMessage()
        );
        return handleExceptionInternal(ex, error, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        log.error(ex.getMessage());
        ErrorDetailsDto error = new ErrorDetailsDto(
                request,
                HttpStatus.BAD_REQUEST,
                ex.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(", "))
        );
        return handleExceptionInternal(ex, error, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(
            BindException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        log.error(ex.getMessage());
        ErrorDetailsDto error = new ErrorDetailsDto(
                request,
                HttpStatus.BAD_REQUEST,
                ex.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(", "))
        );
        return handleExceptionInternal(ex, error, headers, HttpStatus.BAD_REQUEST, request);
    }
}