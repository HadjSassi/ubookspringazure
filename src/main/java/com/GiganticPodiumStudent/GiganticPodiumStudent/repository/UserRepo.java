package com.GiganticPodiumStudent.GiganticPodiumStudent.repository;

import com.GiganticPodiumStudent.GiganticPodiumStudent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;


public interface UserRepo extends JpaRepository<User, String> {
    User findByMailUserIgnoreCase(String emailId);
    void deleteByUid(String uid);
    User findByUid(String uid);
    User findByMailUser(String mail);
}
