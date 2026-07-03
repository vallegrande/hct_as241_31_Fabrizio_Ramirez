package hct.Ramirez.Fabrizio.respository;

import hct.Ramirez.Fabrizio.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente ,String> {
}
