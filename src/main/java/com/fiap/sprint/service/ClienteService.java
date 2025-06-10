package com.fiap.sprint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fiap.sprint.dto.ClienteRequestCreate;
import com.fiap.sprint.dto.ClienteRequestUpdate;
import com.fiap.sprint.model.Cliente;
import com.fiap.sprint.repository.ClienteRepository;

@SpringBootApplication
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> update(Long id,
            ClienteRequestUpdate dto) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(dto.getNome());
                    cliente.setValor_investido(dto.getValor_investido());
                    cliente.setNumero_conta(dto.getNumero_conta());
                    cliente.setPerfil_investidor(dto.getPerfil_investidor());
                    cliente.setIdade(dto.getIdade());
                    return clienteRepository.save(cliente);
                });

    }

    public Cliente save(ClienteRequestCreate dto) {

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setValor_investido(dto.getValor_investido());
        cliente.setNumero_conta(dto.getNumero_conta());
        cliente.setPerfil_investidor(dto.getPerfil_investidor());
        cliente.setIdade(dto.getIdade());

        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
