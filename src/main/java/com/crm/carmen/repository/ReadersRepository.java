package com.crm.carmen.repository;

import com.crm.carmen.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadersRepository extends JpaRepository<Reader, Integer> {

    List<Reader> findByFirstName(String firstName);
}
