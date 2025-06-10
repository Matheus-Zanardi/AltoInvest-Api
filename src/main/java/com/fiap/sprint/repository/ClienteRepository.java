package com.fiap.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.sprint.model.Cliente;

@Repository
public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {

}