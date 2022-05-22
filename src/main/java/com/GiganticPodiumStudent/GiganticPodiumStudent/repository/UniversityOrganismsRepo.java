package com.GiganticPodiumStudent.GiganticPodiumStudent.repository;

import com.GiganticPodiumStudent.GiganticPodiumStudent.model.UniversityOrganisms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UniversityOrganismsRepo extends JpaRepository<UniversityOrganisms, Long> {
}
