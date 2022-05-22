package com.GiganticPodiumStudent.GiganticPodiumStudent.Controller;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.SettingService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Settings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/settings")
public class SettingsCtrl {
    private final SettingService settingService;
    public SettingsCtrl (SettingService settingService){this.settingService = settingService;}

    @GetMapping("/all")
    public ResponseEntity<List<Settings>> getAllSettings (){
        List<Settings> settings= this.settingService.findAllSettings();
        return new ResponseEntity<>(settings, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Settings> getSettingsById (@PathVariable("id") Long id){
        Settings settings = this.settingService.findSettingsById(id);
        return new ResponseEntity<>(settings,HttpStatus.OK);
    }

    @GetMapping("/findData/{anne}&{mati}&{niv}")
    public ResponseEntity<Settings> getSettingsByData (@PathVariable("anne") String anne,@PathVariable("mati") String mati, @PathVariable("niv") String niv){
        Settings settings = this.settingService.findSettingByData(anne,mati,niv);
        return new ResponseEntity<>(settings,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Settings> addSettings (@RequestBody Settings settings){
        Settings newSettings = this.settingService.addSetting(settings);
        return new ResponseEntity<>(newSettings, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Settings> updateSettings (@RequestBody Settings settings){
        Settings updateSettings = this.settingService.updateSettings(settings);
        return new ResponseEntity<>(updateSettings,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSettingsById (@PathVariable("id") Long id){
        this.settingService.deleteSettings(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
