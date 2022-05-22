package com.GiganticPodiumStudent.GiganticPodiumStudent.Service;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Exception.UserNotFoundException;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Institus;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.UniversityOrganisms;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.InstitusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitusService {

    private final InstitusRepo InstitusRepo ;

    @Autowired
    public InstitusService(InstitusRepo InstitusRepo) {
        this.InstitusRepo = InstitusRepo;
    }

    public Institus addInstitus (Institus Institus){return this.InstitusRepo.save(Institus);}
    public List<Institus> findAllInstitus() {
        List<UniversityOrganisms> lll = InstitusRepo.findAll();
        List<Institus> ll = new ArrayList<>();
        for (UniversityOrganisms u : lll) {
            if ( u instanceof Institus) {
                ll.add((Institus) u);
            }
        }
        return ll;
    }

    public Institus findInstitusById(Long id) {
        return ((Institus)(InstitusRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Institus with the id = " + id + " was not found"))));
    }
    public Institus updateInstitus (Institus Institus) { return InstitusRepo.save(Institus);}

    public void deleteInstitus (Long id) { this.InstitusRepo.deleteById(id);}


}
