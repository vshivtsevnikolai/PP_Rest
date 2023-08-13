package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query("SELECT u from User u join fetch u.roles where u.username = :username")
    User findByUsername(@Param("username") String username);
}
