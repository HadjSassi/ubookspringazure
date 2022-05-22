package com.GiganticPodiumStudent.GiganticPodiumStudent.Service;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Exception.UserNotFoundException;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Settings;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.SettingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService {

    private final SettingsRepo settingsRepo ;

    @Autowired

    public SettingService(SettingsRepo settingsRepo) {
        this.settingsRepo = settingsRepo;
    }

    public Settings addSetting (Settings settings) {return this.settingsRepo.save(settings);}
    public List<Settings> findAllSettings () {return settingsRepo.findAll();}
    public Settings findSettingsById (Long id) { return settingsRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Institus with the id = " + id + " was not found"));}
    public Settings updateSettings (Settings settings) {return settingsRepo.save(settings);}
    public void deleteSettings (Long id) {this.settingsRepo.deleteById(id);}
    public Settings findSettingByData(String annee, String matiere, String nivea) {return settingsRepo.findByAnneeAndMatiereAndNiveau(annee,matiere,nivea);}

}
