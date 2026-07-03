package hct.Ramirez.Fabrizio.service.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import hct.Ramirez.Fabrizio.model.Cliente;
import hct.Ramirez.Fabrizio.respository.ClienteRepository;
import hct.Ramirez.Fabrizio.service.ClienteService;

@Service
public class ClienteImpl implements ClienteService {
    private final ClienteRepository repository;

    public ClienteImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Cliente> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Cliente> create(Cliente cliente) {
        if (cliente.getEstado() == null) {
            cliente.setEstado("Activo");
        }
        return repository.save(cliente);
    }

    @Override
    public Mono<Cliente> edit(String id, Cliente cliente) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setNombres(cliente.getNombres());
                    existing.setApellidos(cliente.getApellidos());
                    existing.setDni(cliente.getDni());
                    existing.setCelular(cliente.getCelular());
                    existing.setCorreo(cliente.getCorreo());
                    existing.setLicencia(cliente.getLicencia());
                    existing.setEstado(cliente.getEstado());
                    return repository.save(existing);
                });
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setEstado("Inactivo");
                    return repository.save(existing);
                })
                .then();
    }

    @Override
    public Mono<Void> restore(String id) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setEstado("Activo");
                    return repository.save(existing);
                })
                .then();
    }
}