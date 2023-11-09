package com.practice.userservice.repository;

import com.practice.userservice.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
    Session save(Session session);

    Session findSessionByTokenAndUser_Id(String token,Long id);
}
