package com.demo.hr.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.hr.utils.Result;


/**
 * Spring 全局进行异常回调
 */
@ControllerAdvice
public class SpringExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Controller 参数缺少时,异常回调。
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        // MissingServletRequestParameterException handling code goes here.
    	Result tResult = new Result();
        tResult.setStatus( -1 );
        tResult.setErrorMessage(ex.getMessage());
        return new ResponseEntity<Object>(tResult, HttpStatus.OK);
    }

    /**
     * 全局处理Exception
     * 错误的情况下返回500
     *
     * @param ex
     * @param req
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(final Exception ex, final WebRequest req) {
        Result tResult = new Result();
        tResult.setStatus(500);
        tResult.setErrorMessage("系统开小差了，请稍后再试");
        return new ResponseEntity<Object>(tResult, HttpStatus.OK);
    }

}
