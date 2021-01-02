package com.crm.carmen.service;

import com.crm.carmen.dto.ReadersDto;
import com.crm.carmen.exception.ValidationException;

import java.util.List;

public interface ReadersService {

    ReadersDto saveUser(ReadersDto usersDto) throws ValidationException;

    void deleteReader(Integer readerId);

    List<ReadersDto> findByFirstName(String firstName);

    List<ReadersDto> findAll();
}
