package com.university.project.controller;

import com.university.project.domain.Message;
import com.university.project.domain.User;
import com.university.project.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/*
@Controller
public class MainController {

    //upload.path =  /c:/Users/User/AppData/Local/Temp/tomcat.8081.18408716255723072654/work/Tomcat/localhost/ROOT
    @Autowired
    private MessageRepository messageRepository;

    @Value("${upload.path}")//указываем спрингу что хотим получить из контекста переменную
    private String uploadPath; //встаавляем это в переменную

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
        } else {
            messages = messageRepository.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }


    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model,
            @RequestParam("file") MultipartFile file)
            throws IOException {
        Message message = new Message(text, tag, user);
        if (file != null && !file.getOriginalFilename().isEmpty()){ //загружаем картинку

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir(); //если не сущ, создаем путь
            }

            String uuidFile = UUID.randomUUID().toString() ; //создаем уникальное имя файла
            String resultFileName = uuidFile + "." + file.getOriginalFilename(); //имя файла

            file.transferTo(new File(uploadPath + "/" + resultFileName)); //загружаем
            message.setFilename(resultFileName);
        }
        messageRepository.save(message); //сохранили сообщение
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        model.put("filter", "");
        return "main";
    }
}
*/

@Controller
public class MainController {
    @Autowired
    private MessageRepository messageRepo;

    @Value("${upload.path}")
    private String uploadPath;

   /* @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }*/

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Message message = new Message(text, tag, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            message.setFilename(resultFilename);
        }

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }
}