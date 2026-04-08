package com.example.demo.repository;

import com.example.demo.entity.Division;
import com.example.demo.entity.Guest;
import com.example.demo.entity.GuestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionsRepository extends JpaRepository<Division,Long> {
    List<Division>findByStreet(String street);
}
