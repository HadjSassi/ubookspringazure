package com.GiganticPodiumStudent.GiganticPodiumStudent.Controller;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Config;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {

    private final String path = Config.path;

    @RequestMapping(value = "/upload/Document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String documentUpload (@RequestParam("file") MultipartFile file)throws IOException{
        File convertFile = new File(path+"Documents/"+file.getOriginalFilename());
        Boolean b = convertFile.createNewFile();
        try (FileOutputStream fout = new FileOutputStream(convertFile)){
            fout.write(file.getBytes());
        } catch (Exception exe){
            exe.printStackTrace();
        }
        return "File has uploaded successfully";
    }


    @RequestMapping(value = "/upload/Event", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String eventUpload (@RequestParam("file") MultipartFile file)throws IOException{
        File convertFile = new File(path+"Event/"+file.getOriginalFilename());
        convertFile.createNewFile();
        try (FileOutputStream fout = new FileOutputStream(convertFile)){
            fout.write(file.getBytes());
        } catch (Exception exe){
            exe.printStackTrace();
        }
        return "File has uploaded successfully";
    }

    @RequestMapping(value = "/upload/PicUser", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String picUserUpload (@RequestParam("file") MultipartFile file)throws IOException{
        File convertFile = new File(path+"PicUser/"+file.getOriginalFilename());
        Boolean b = convertFile.createNewFile();
        try (FileOutputStream fout = new FileOutputStream(convertFile)){
            fout.write(file.getBytes());
        } catch (Exception exe){
            exe.printStackTrace();
        }
        return "File has uploaded successfully";
    }

}
