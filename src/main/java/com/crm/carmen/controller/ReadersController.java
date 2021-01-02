package com.crm.carmen.controller;

import com.crm.carmen.dto.ReadersDto;
import com.crm.carmen.service.ReadersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crm.carmen.exception.ValidationException;

import java.util.List;

@RestController
@RequestMapping("/reader")
@AllArgsConstructor
@Log
public class ReadersController {

    private final ReadersService readersService;

    @PostMapping("/save")
    public ReadersDto saveReaders(@RequestBody ReadersDto readersDto) throws ValidationException {
        log.info("Handling save readers: " + readersDto);
        return readersService.saveUser(readersDto);
    }

    @GetMapping("/findAll")
    public List<ReadersDto> findAllUsers() {
        log.info("Handling find all readers request");
        return readersService.findAll();
    }

    @GetMapping("/findByFirstName")
    public List<ReadersDto> findByFirstName(@RequestParam String firstName) {
        log.info("Handling find by first name request: " + firstName);
        return readersService.findByFirstName(firstName);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReader(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        readersService.deleteReader(id);
        return ResponseEntity.ok().build();
    }
}
