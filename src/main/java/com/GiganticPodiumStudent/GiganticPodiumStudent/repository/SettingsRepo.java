package com.GiganticPodiumStudent.GiganticPodiumStudent.repository;

import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsRepo extends JpaRepository<Settings, Long> {
    Settings  findByAnneeAndMatiereAndNiveau (String annee, String matiere, String nivea);
}
