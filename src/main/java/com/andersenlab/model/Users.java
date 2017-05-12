package com.andersenlab.model;

import javax.persistence.*;

/**
 * Class for implementing realization of JPA
 *
 * @author Vlad Badilovskii
 * @version 4.0
 */
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    /**
     * Gets id.
     *
     * @return id parameter
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id is input parameter for this method
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return name parameter
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name is input parameter for this method
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets last name.
     *
     * @return lastName parameter
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName is input parameter for this method
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @param o is abstract representation of compared object
     * @return true - if objects are equal and false if vice versa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        return lastName != null ? lastName.equals(users.lastName) : users.lastName == null;
    }

    /**
     *
     * @return a numeric representation of the object
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    /**
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
