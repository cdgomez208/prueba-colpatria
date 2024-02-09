package com.prueba.tecnica.backend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)

public class CustomerClientDTO {

    private String name;


    private int age;


    private String phoneNumber;

    private String address;
}
