package com.simplon.dvdstore.repositories.owner;

import com.simplon.dvdstore.domain.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Owner repository.
 */
@Repository

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    /**
     * Find by login owner.
     *
     * @param login the login
     * @return the owner
     */
    Owner findByLogin(String login);
}
