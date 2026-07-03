package hct.Ramirez.Fabrizio.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import hct.Ramirez.Fabrizio.model.Cliente;

public interface ClienteService {
    Flux<Cliente> findAll();
    Mono<Cliente> findById(String id);
    Mono<Cliente> create(Cliente cliente);
    Mono<Cliente> edit(String id, Cliente cliente);
    Mono<Void> delete(String id);
    Mono<Void> restore(String id);
}