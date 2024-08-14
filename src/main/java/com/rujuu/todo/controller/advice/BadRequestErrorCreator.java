package com.rujuu.todo.controller.advice;

import com.rujuu.todo.model.BadRequestError;
import com.rujuu.todo.model.InvalidParam;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public class BadRequestErrorCreator {
    public static BadRequestError from(MethodArgumentNotValidException ex) {
        var invalidParamList = createInvalidParamList(ex);
        var error = new BadRequestError();
        error.setInvalidParams(invalidParamList);
        return error;
    }

    private static List<InvalidParam> createInvalidParamList(MethodArgumentNotValidException ex) {
        return ex.getFieldErrors()
                .stream()
                .map(BadRequestErrorCreator::createInvalidParam)
                .toList();
    }

    private static InvalidParam createInvalidParam(FieldError fieldError) {
        var invalidParam = new InvalidParam();
        invalidParam.setName(fieldError.getField());
        invalidParam.setReason(fieldError.getDefaultMessage());
        return invalidParam;
    }
}
