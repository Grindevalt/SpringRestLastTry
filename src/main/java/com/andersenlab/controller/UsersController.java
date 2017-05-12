package com.andersenlab.controller;

import com.andersenlab.model.Users;
import com.andersenlab.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Users controller.
 *
 * @author Vlad Badilovskii
 * @version 4.0
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    /**
     * Find all users.
     *
     * @return the list of users
     */
    @GetMapping(value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> findAll() {
        return userJpaRepository.findAll();
    }

    /**
     * Create user.
     *
     * @param users received from outside
     */
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody final Users users) {
        userJpaRepository.save(users);
    }

    /**
     * Find by id users.
     *
     * @param id - user parameter of which we want to find
     * @return the users whom we were looking for
     */
    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Users findById(@PathVariable final Long id) {
        return userJpaRepository.findById(id);
    }

    /**
     * Update user.
     *
     * @param id - user parameter of which we want to update
     * @param users received from outside
     */
    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable final Long id, @RequestBody final Users users) {
        Users oldUser = userJpaRepository.findById(id);
        oldUser.setName(users.getName());
        oldUser.setLastName(users.getLastName());
        userJpaRepository.save(oldUser);
    }

    /**
     * Delete user.
     *
     * @param id - user parameter of which we want to remove
     */
    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable final Long id) {
        userJpaRepository.delete(id);
    }


}
