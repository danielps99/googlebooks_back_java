package br.com.bdws.gbooks.config;

import br.com.bdws.gbooks.exception.GenericException;
import br.com.bdws.gbooks.exception.SupportGenericException;
import br.com.bdws.gbooks.viewObject.ResponseEntityExceptionVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@ControllerAdvice
public class ApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({GenericException.class})
    public ResponseEntityExceptionVO handleGenericException(HttpServletRequest request, GenericException ex) {
        return ResponseEntityExceptionVO.builder().url(request.getRequestURI()).message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({SupportGenericException.class, RuntimeException.class})
    public ResponseEntityExceptionVO handleRuntimeException(HttpServletRequest request, RuntimeException ex) {
        UUID uuid = UUID.randomUUID();
        String message = "Desculpe o transtorno! Algo errado aconteceu! Código: " + uuid;
        String messageLog = String.format("%s - %s - %s.", uuid, request.getRequestURI(), ex.getMessage());
        logger.warn(messageLog);
        return ResponseEntityExceptionVO.builder().url(request.getRequestURI()).message(message).build();
    }
}
