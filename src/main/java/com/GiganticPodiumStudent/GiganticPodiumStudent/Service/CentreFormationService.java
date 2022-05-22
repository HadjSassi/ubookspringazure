package com.GiganticPodiumStudent.GiganticPodiumStudent.Service;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Exception.UserNotFoundException;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.CentreFormation;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.UniversityOrganisms;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.CentreFormationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CentreFormationService {
    
    private final CentreFormationRepo centreFormationRepo;

    @Autowired
    public CentreFormationService(CentreFormationRepo centreFormationRepo) {
        this.centreFormationRepo = centreFormationRepo;
    }

    public CentreFormation addCentreFormation (CentreFormation centreFormation){return this.centreFormationRepo.save(centreFormation);}

    public List<CentreFormation> findAllCentreFormation() {
        List<UniversityOrganisms> lll = centreFormationRepo.findAll();
        List<CentreFormation> ll = new ArrayList<>();
        for (UniversityOrganisms u : lll) {
            if ( u instanceof CentreFormation) {
                ll.add((CentreFormation) u);
            }
        }
        return ll;
    }

    public CentreFormation findCentreFormationById(Long id) {
        return ((CentreFormation)(centreFormationRepo.findById(id).orElseThrow(() -> new UserNotFoundException("CentreFormation with the id = " + id + " was not found"))));
    }
    public CentreFormation updateCentreFormation (CentreFormation CentreFormation) { return centreFormationRepo.save(CentreFormation);}

    public void deleteCentreFormation (Long id) { this.centreFormationRepo.deleteById(id);}


}
