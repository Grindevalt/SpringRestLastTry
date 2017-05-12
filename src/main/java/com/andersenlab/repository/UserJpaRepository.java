package com.andersenlab.repository;

import com.andersenlab.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Interface for getting all needed CRUD methods
 *
 * @author Vlad Badilovskii
 * @version 4.0
 */
@Component
public interface UserJpaRepository extends JpaRepository<Users, Long> {

    /**
     * Find by id users.
     *
     * @param id the id
     * @return the users
     */
    Users findById(Long id);
}
