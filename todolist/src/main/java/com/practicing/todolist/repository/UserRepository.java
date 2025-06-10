package com.practicing.todolist.repository;

import com.practicing.todolist.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByEmail(String email);
//
//    Optional<User> findByEmail(String email);
//
//    @Modifying
//    @Query("UPDATE User u SET u.name = :name, u.email = :email WHERE u.id = :id")
//    int updateUserById(@Param("id") UUID id, @Param("name") String name, @Param("email") String email);
//
//    // Custom method to ensure we're working with managed entities
//    @Query("SELECT u FROM User u WHERE u.id = :id")
//    Optional<User> findByIdForUpdate(@Param("id") UUID id);
}
