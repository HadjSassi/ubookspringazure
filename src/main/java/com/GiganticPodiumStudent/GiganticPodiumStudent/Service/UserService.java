package com.GiganticPodiumStudent.GiganticPodiumStudent.Service;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Config;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.User;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.server.UID;
import java.util.List;

@Service
public class UserService {

    private final String path = Config.path+"../../";
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(String uid) {
        User user = userRepo.findByUid(uid);
        Path fileToDeletePath = Paths.get(path + user.getUrlPicUser());
        try {
            Files.delete(fileToDeletePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.userRepo.deleteByUid(uid);
    }

    public void resetPicture(String uid) {
        User user = userRepo.findByUid(uid);
        if (!user.getUrlPicUser().equals("../../../../assets/img/icon.png")) {
            Path fileToDeletePath = Paths.get(path + user.getUrlPicUser());
            try {
                Files.delete(fileToDeletePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public User findUserByUid(String uid) {
        return userRepo.findByUid(uid);
    }
    public User findUserByEmail(String mail) {
        return userRepo.findByMailUser(mail);
    }

}
