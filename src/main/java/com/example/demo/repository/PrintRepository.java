package com.example.demo.repository;

import com.example.demo.model.Print;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintRepository extends JpaRepository<Print, Long> {

}