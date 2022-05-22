package com.GiganticPodiumStudent.GiganticPodiumStudent.Controller;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Config;
import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.EmailSenderService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.UserService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.ConfirmationToken;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.User;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.ConfirmationTokenRepo;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCtrl {

    private final UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ConfirmationTokenRepo confirmationTokenRepo;

    @Autowired
    private EmailSenderService emailSenderService;

    public UserCtrl (UserService userService) {this.userService = userService;}

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser (){
        List<User> users=  this.userService.findAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/findUid/{uid}")
    public ResponseEntity<User> getUserByUid (@PathVariable("uid") String uid){
        User user=  this.userService.findUserByUid(uid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById (@PathVariable("id") String  id){
        this.userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletePicUser/{id}")
    public ResponseEntity<?> resetUrlPic (@PathVariable("id") String  id){
        this.userService.resetPicture(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser (@RequestBody User user){
        User newUser=  this.userService.addUser(user);
        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenRepo.save(confirmationToken);
        emailSenderService.activationAccount(newUser,confirmationToken);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/confirmation")
    @PostMapping("/confirmation")
    public RedirectView confirmUserAccount(@RequestParam("token") String confirmationToken){
        ConfirmationToken token = confirmationTokenRepo.findByConfirmationToken(confirmationToken);
        RedirectView redirectView = new RedirectView();
        if (token != null){
            User user = userRepo.findByMailUserIgnoreCase(token.getUserEntity().getMailUser());
            user.setEnabled(true);
            userRepo.save(user);
            this.confirmationTokenRepo.delete(token);
            redirectView.setUrl(Config.redirectedPath);
            return redirectView;
        }
        redirectView.setUrl(Config.errorPath);
        return redirectView;
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser (@RequestBody User user){
        User updateUser=  this.userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @PostMapping("/forget")
    public void forgetPwd (@RequestBody String mail){
        try {
            User newUser=  this.userService.findUserByEmail(mail);
            ConfirmationToken confirmationToken = new ConfirmationToken(newUser);
            confirmationTokenRepo.save(confirmationToken);
            emailSenderService.ForgetPassword(newUser,confirmationToken);
        }catch (Exception e){
            System.out.println("No User Found!");
        }

    }
/*
    @GetMapping("/forgetpwd")
    @PostMapping("/forgetpwd")
    public RedirectView forgetPassword2(@RequestParam("token") String confirmationToken){
        ConfirmationToken token = confirmationTokenRepo.findByConfirmationToken(confirmationToken);
        RedirectView redirectView = new RedirectView();
        if (token != null){
            User user = userRepo.findByMailUserIgnoreCase(token.getUserEntity().getMailUser());
//            this.confirmationTokenRepo.delete(token);
            redirectView.setUrl(Config.ForgetPath);
            redirectView.addStaticAttribute("email",user.getMailUser());
            System.out.println(redirectView);
            return redirectView;
        }
        redirectView.setUrl(Config.errorPath);
        return redirectView;
    }*/


    @GetMapping("/forgetpwd")
    @PostMapping("/forgetpwd")
    public ModelAndView forgetPassword(@RequestParam("token") String confirmationToken){
        ConfirmationToken token = confirmationTokenRepo.findByConfirmationToken(confirmationToken);
        if (token != null){
            ModelMap modelMap = new ModelMap();
            User user = userRepo.findByMailUserIgnoreCase(token.getUserEntity().getMailUser());
            modelMap.addAttribute("email",user.getMailUser());
            System.out.println(new ModelAndView("redirect:"+Config.ForgetPath,modelMap));
            return new ModelAndView("redirect:"+Config.ForgetPath,modelMap);
        }
        return new ModelAndView("redirect:"+Config.errorPath);
    }



}
