package com.fiap.sprint.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.sprint.dto.ClienteRequestCreate;
import com.fiap.sprint.dto.ClienteRequestUpdate;
import com.fiap.sprint.dto.ResponseCliente;
import com.fiap.sprint.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    public ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ResponseCliente>> findAll() {
        return ResponseEntity.ok(clienteService
                .findAll()
                .stream()
                .map(cliente -> new ResponseCliente().toDto(cliente))
                .collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseCliente> findById(@PathVariable Long id) {
        return clienteService.findById(id)
                .map(cliente -> ResponseEntity.ok(new ResponseCliente().toDto(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResponseCliente> create(@RequestBody ClienteRequestCreate dto) {

        return ResponseEntity.status(201).body(
                new ResponseCliente().toDto(
                        clienteService.save(dto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseCliente> update(
            @PathVariable Long id,
            @RequestBody ClienteRequestUpdate dto) {

        return clienteService.update(id, dto)
                .map(cliente -> ResponseEntity.ok(new ResponseCliente().toDto(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = clienteService.deleteById(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
