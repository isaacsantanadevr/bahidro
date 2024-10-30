package com.isaac.bahidro.repository;

import com.isaac.bahidro.model.Bacia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaciaRepository extends MongoRepository<Bacia, String> {
    // Adicionar metodos de consulta personalizados, quando necessario
}
