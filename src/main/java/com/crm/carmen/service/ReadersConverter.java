package com.crm.carmen.service;

import com.crm.carmen.dto.ReadersDto;
import com.crm.carmen.entity.Reader;
import org.springframework.stereotype.Component;

@Component
public class ReadersConverter {

    public Reader fromReaderDtoToReader(ReadersDto readersDto) {
        Reader reader = new Reader();
        reader.setId(readersDto.getId());
        reader.setFirstName(readersDto.getFirstName());
        reader.setLastName(readersDto.getLastName());
        reader.setPatronymic(readersDto.getPatronymic());
        reader.setAddress(readersDto.getAddress());
        reader.setPhoneNumber(readersDto.getPhoneNumber());
        return reader;
    }

    public ReadersDto fromReaderToReaderDto(Reader reader) {
        return ReadersDto.builder()
                .id(reader.getId())
                .firstName(reader.getFirstName())
                .lastName(reader.getLastName())
                .patronymic(reader.getPatronymic())
                .address(reader.getAddress())
                .phoneNumber(reader.getPhoneNumber())
                .build();
    }
}
