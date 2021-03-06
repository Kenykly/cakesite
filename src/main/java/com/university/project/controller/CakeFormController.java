package com.university.project.controller;

import com.university.project.domain.*;
import com.university.project.repos.*;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
public class CakeFormController {

    @Autowired
    private  IngredientRepository ingredientRepository;


    @Autowired
    private CakeRepository cakeRepository;
    

    @Value("${upload.path}")//указываем спрингу что хотим получить из контекста переменную
    private String uploadPath; //встаавляем это в переменную


    double kForTwoStage = 1.7;
    double kForThreeStage = 2.4;
    double marginSumm = 2.5;

    @GetMapping("/make")
    public String showCakeForm(Model model) {

        //выводим в форму создания досупные вкусы крема, бисквита, начинок
       // Iterable<Biscuit> biscuitnames = biscuitRepository.findAll();
        Iterable<Ingredient> biscuitnames = ingredientRepository.findByIngtype("Бисквит");
        model.addAttribute("biscuitnames", biscuitnames);

        Iterable<Ingredient> creamnames = ingredientRepository.findByIngtype("Крем");
        //Iterable<Cream> creamnames = creamRepository.findAll();
        model.addAttribute("creamnames", creamnames);

        //Iterable<Filling> fillingnames = fillingRepository.findAll();
        Iterable<Ingredient> fillingnames = ingredientRepository.findByIngtype("Начинка");
        model.addAttribute("fillingnames", fillingnames );

        return "makeacake";
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


        Ingredient biscuit = ingredientRepository.findByTastenameAndIngtype(biscuitname, "Бисквит").get(0);
        //Biscuit biscuit = biscuitRepository.findByTastename(biscuitname).get(0);


        //Filling filling = fillingRepository.findByTastename(fillingname).get(0);
        Ingredient filling = ingredientRepository.findByTastenameAndIngtype(fillingname, "Начинка").get(0);


        //Cream cream = creamRepository.findByTastename(creamname).get(0);
        Ingredient cream = ingredientRepository.findByTastenameAndIngtype(creamname, "Крем").get(0);

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

        boolean isInBasket = true;
        double cakePrice = countCakePrice(biscuit, cream, filling, stageCount, personCount);
        List<Ingredient> ingredients = new ArrayList<Ingredient>();

        ingredients.add(filling);
        ingredients.add(biscuit);
        ingredients.add(cream);
        //List<Ingredient> ingredients;
        //ingredients = {filling, biscuit, cream};

       // List<Ingredient> ingredients = new {filling, biscuit};
        Cake cake = new Cake(user, isInBasket, stageCount, cakeform, personCount, cakePrice, decorDescription, resultFileName, ingredients,  /*biscuit, cream, filling,*/ cakeComment);
        cakeRepository.save(cake);

        return "cakeismade";
    }


    private double countCakePrice(Ingredient biscuit, Ingredient cream, Ingredient filling, int stageCount, int personCount) {

        double stageK = 1;
        if (stageCount == 2){
            stageK = kForTwoStage;
        }
        else{
            if (stageCount == 3){
                stageK = kForThreeStage;
            }
        }

        double price = marginSumm * stageK * personCount * (biscuit.getPrice() + cream.getPrice() + filling.getPrice());
        return  price;
    }

}
