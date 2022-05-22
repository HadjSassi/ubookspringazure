package com.GiganticPodiumStudent.GiganticPodiumStudent.Service;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Exception.UserNotFoundException;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Club;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.UniversityOrganisms;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.ClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClubService {

    private final ClubRepo clubRepo ;

    @Autowired
    public ClubService(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    public Club addClub (Club club){return this.clubRepo.save(club);}

    public List<Club> findAllClub() {
        List<UniversityOrganisms> lll = clubRepo.findAll();
        List<Club> ll = new ArrayList<>();
        for (UniversityOrganisms u : lll) {
            if ( u instanceof Club) {
                ll.add((Club) u);
            }
        }
        return ll;
    }

    public Club findClubById(Long id) {
        return ((Club)(clubRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Club with the id = " + id + " was not found"))));
    }

    public Club updateClub (Club club) { return clubRepo.save(club);}

    public void deleteClub (Long id) { this.clubRepo.deleteById(id);}


}
