package com.simplon.dvdstore.repositories.clients;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientRepositoryModel,Long> {
}
