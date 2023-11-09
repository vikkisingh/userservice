package com.practice.userservice.repository;

import com.practice.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User,Long> {
    User save(User user);

    User findUserByEmail(String email);
}
