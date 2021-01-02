package com.crm.carmen.service;

import com.crm.carmen.dto.ReadersDto;
import com.crm.carmen.entity.Reader;
import com.crm.carmen.repository.ReadersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.crm.carmen.exception.ValidationException;


import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DeafaultUsersService implements ReadersService{

    private final ReadersRepository readersRepository;
    private final ReadersConverter readersConverter;

    @Override
    public ReadersDto saveUser(ReadersDto readersDto) throws ValidationException {
        validateReaderDto(readersDto);
        Reader savedUser = readersRepository.save(readersConverter.fromReaderDtoToReader(readersDto));
        return readersConverter.fromReaderToReaderDto(savedUser);
    }

    private void validateReaderDto(ReadersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getFirstName()) || usersDto.getFirstName().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public void deleteReader(Integer readerId) {
        readersRepository.deleteById(readerId);
    }

    @Override
    public List<ReadersDto> findByFirstName(String firstName) {
        List<Reader> readers = readersRepository.findByFirstName(firstName);
        return readers.stream().map(readersConverter::fromReaderToReaderDto).collect(Collectors.toList());
    }

    @Override
    public List<ReadersDto> findAll() {
        return readersRepository.findAll()
                .stream()
                .map(readersConverter::fromReaderToReaderDto)
                .collect(Collectors.toList());
    }
}
