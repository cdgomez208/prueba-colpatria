package com.prueba.tecnica.backend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static com.prueba.tecnica.backend.utils.contants.SUCCESS_CODE;
import static com.prueba.tecnica.backend.utils.contants.SUCCESS_MESSAGE;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusDTO {

    private String code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String detailMessageError;

    public StatusDTO(String message) {
        this.code = SUCCESS_CODE;
        this.message = message;
        this.detailMessageError = null;
    }

    public StatusDTO() {
        this.code = SUCCESS_CODE;
        this.message = SUCCESS_MESSAGE;
        this.detailMessageError = null;
    }
}
