package com.bamdule.handler;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author MW
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // 모든 예외 처리
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> allException(Exception ex) {
        logger.error("-- Exception -> [message]: {}", ex.getMessage());

        StackTraceElement[] ste = ex.getStackTrace();
        if (ste != null && ste.length > 0) {
            logger.error("-- Class:[{}] Method:[{}] Line:[{}] ", ste[0].getClassName(), ste[0].getMethodName(), ste[0].getLineNumber());

        }
        Map<String, Object> exceptionObj = new HashMap<>();
        exceptionObj.put("errorCode", 500);
        exceptionObj.put("message", ex.getMessage());

        return exceptionObj;

    }
}
