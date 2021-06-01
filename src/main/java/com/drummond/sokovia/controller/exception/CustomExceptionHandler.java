package com.drummond.sokovia.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.MissingFormatArgumentException;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<ErroDTO> excecaoPadrao(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErroDTO.builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .mensagem(ex.getMessage())
                        .build());
    }
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErroDTO> onConstraintViolationException(ConstraintViolationException ex){

        String errorDetail = ex.getConstraintViolations()
                .stream().map(error -> String.format("%s = %s",error.getPropertyPath().toString(),
                        error.getPropertyPath().toString(),
                        error.getMessage()))
                .collect(Collectors.joining(", "));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErroDTO.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .mensagem(errorDetail)
                        .build()
                );
    }

    @ExceptionHandler(MissingFormatArgumentException.class)
    public ResponseEntity<ErroDTO> onMissingFormatArgumentException(MissingFormatArgumentException ex){
         final ErroDTO errorResponse = ErroDTO.builder().code(HttpStatus.BAD_REQUEST.value())
                 .mensagem(ex.getMessage())
                 .build();
         return new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(HeroiCadastradoException.class)
    public ResponseEntity<ErroDTO> onAlunoInexistenteException(HeroiCadastradoException ex){
        final ErroDTO errorResponse = ErroDTO.builder().code(HttpStatus.BAD_REQUEST.value())
                .mensagem(ex.getMessage())
                .build();
        return new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
