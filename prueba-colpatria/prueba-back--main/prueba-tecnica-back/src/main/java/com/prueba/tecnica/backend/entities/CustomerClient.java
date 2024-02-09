package com.prueba.tecnica.backend.entities;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "\"client\"", schema = "public")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CustomerClient implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "nameCustomer", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;


}
