package com.GiganticPodiumStudent.GiganticPodiumStudent.repository;

import com.GiganticPodiumStudent.GiganticPodiumStudent.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConfirmationTokenRepo extends JpaRepository<ConfirmationToken, Long > {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
