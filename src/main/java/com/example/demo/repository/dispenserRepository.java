package com.example.demo.repository;

import com.example.demo.model.UserObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface dispenserRepository extends JpaRepository<UserObject, String> {
}
