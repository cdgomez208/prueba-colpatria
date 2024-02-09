package com.prueba.tecnica.backend.dtos;

public class ResponseDTO {


    private StatusDTO status;

    public ResponseDTO(StatusDTO statusDTO) {
    }

    public static ResponseDTO apply(String message) {
        return new ResponseDTO(new StatusDTO(message));
    }

}
