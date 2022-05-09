package com.university.project.controller;

import com.university.project.domain.*;
import com.university.project.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class CakeFormController {

    @Autowired
    private CakeRepository cakeRepository;

    @Autowired
    private CreamRepository creamRepository;

    @Autowired
    private BiscuitRepository biscuitRepository;

    @Autowired
    private FillingRepository fillingRepository;

    @Value("${upload.path}")//указываем спрингу что хотим получить из контекста переменную
    private String uploadPath; //встаавляем это в переменную


    @GetMapping("/make")
    public String showCakeForm() {
        return "make";
    }


    @PostMapping("/make")
    public String createCake(@AuthenticationPrincipal User user,
                             @RequestParam String decorDescription,
                             @RequestParam int personCount,
                             @RequestParam int stageCount,
                             @RequestParam String cakeComment,
                             @RequestParam("file") MultipartFile file,
                             @RequestParam String cakeform,
                             @RequestParam String biscuitname,
                             @RequestParam String creamname,
                             @RequestParam String  fillingname
                             ) throws IOException {
        //здесь,  наверное, лучше сделать какой-то набор готовый кремов, бисквитов и начинок с установленными ценами
        //при созданнии торта находить в сущности цену (по выбранному в форме имени) и считать сумму по этим значениям

        //запрос по уникальному имени - буду искать стоимость бисквита и его id вместо создания сущности
        Biscuit biscuit = new Biscuit(biscuitname);
        biscuitRepository.save(biscuit);

        Cream cream = new Cream(creamname);
        creamRepository.save(cream);

        Filling filling = new Filling(fillingname);
        fillingRepository.save(filling);

        String resultFileName = "";
        if (file != null && !file.getOriginalFilename().isEmpty()){ //загружаем картинку

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir(); //если не сущ, создаем путь
            }

            String uuidFile = UUID.randomUUID().toString() ; //создаем уникальное имя файла
            resultFileName = uuidFile + "." + file.getOriginalFilename(); //имя файла

            file.transferTo(new File(uploadPath + "/" + resultFileName)); //загружаем
        }

        //посчитать сумму
        Cake cake = new Cake(stageCount, cakeform, personCount, 6555, decorDescription, resultFileName,  biscuit, cream, filling, cakeComment);
        cakeRepository.save(cake); //сохранили сообщение

        return "basket";
    }

}
