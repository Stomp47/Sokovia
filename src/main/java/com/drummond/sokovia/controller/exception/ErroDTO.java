package com.drummond.sokovia.controller.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErroDTO {

    private final Integer code;

    private final String mensagem;

}
