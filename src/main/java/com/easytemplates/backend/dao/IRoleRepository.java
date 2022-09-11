package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
 
}