package com.crm.carmen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReadersDto {

    private Integer id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String phoneNumber;

}
