package com.crm.carmen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "reader")
@Data
@NoArgsConstructor

public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column
    private String patronymic;

    @Column
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;
}
