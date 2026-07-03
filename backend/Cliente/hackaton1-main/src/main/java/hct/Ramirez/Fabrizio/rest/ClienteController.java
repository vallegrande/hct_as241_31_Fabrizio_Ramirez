package hct.Ramirez.Fabrizio.rest;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import hct.Ramirez.Fabrizio.model.Cliente;
import hct.Ramirez.Fabrizio.service.ClienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Cliente> finAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Cliente> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/new")
    public Mono<Cliente> create(@RequestBody Cliente cliente) {
        return service.create(cliente);
    }

    @PutMapping("/edit/{id}")
    public Mono<Cliente> edit(@PathVariable String id, @RequestBody Cliente cliente) {
        return service.edit(id, cliente);
    }

    @PatchMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }

    @PatchMapping("/restore/{id}")
    public Mono<Void> restore(@PathVariable String id) {
        return service.restore(id);
    }
}