package com.mypkg.trainersAssignment.controller;

import com.mypkg.trainersAssignment.model.Trainer;
import com.mypkg.trainersAssignment.service.TrainerServiceInterface;
import com.mypkg.trainersAssignment.validators.TrainerValidator;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrainerController {

    @Autowired
    TrainerServiceInterface trainerServiceInterface;

    @Autowired
    TrainerValidator trainerValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(trainerValidator);
    }

    @RequestMapping("/")
    public String home(ModelMap mm) {
        return "redirect:searchtrainer";
    }

    @GetMapping("/searchFortrainer")
    public String searchTrainer(
            ModelMap mm,
            @RequestParam(name = "name") String trainername
    ) {
        List<Trainer> list = trainerServiceInterface.searchTrainers(trainername);
        mm.addAttribute("trainerlist", list);
        return "alltrainerspage";
    }

    @GetMapping("/preinserttrainer")
    public String showForm(ModelMap mm) {
        mm.addAttribute("newtrainer", new Trainer());
        return "trainerform";
    }

    @PostMapping("/doinserttrainer")
    public String insertTrainer(@Valid
            @ModelAttribute("newtrainer") Trainer t, BindingResult bindingResult, ModelMap mm) {

        if (bindingResult.hasErrors()) {
            return "trainerform";
        } else {

            trainerServiceInterface.insertTrainer(t);

           return "redirect:searchtrainer";
        }
    }

    @GetMapping("/searchtrainer")
    public String allTrainers(ModelMap mm) {

//ask service layer for list of trainers 
        List<Trainer> result = trainerServiceInterface.getAllTrainers();

// put list of trainers in model
        mm.addAttribute("trainerlist", result);

        return "alltrainerspage";
    }

    @GetMapping("/deletetrainer")
    public String deleteTrainer(ModelMap mm,
            @RequestParam(name = "idTrainer") int trainerid) {
        trainerServiceInterface.deleteTrainer(trainerid);

        return "redirect:searchtrainer";
    }

    @GetMapping("/edittrainer")
    public String editTrainer(
            ModelMap mm,
            @RequestParam(name = "idTrainer") int trainerid) {

        Trainer t = trainerServiceInterface.findById(trainerid);

        mm.addAttribute("newtrainer", t);

        return "trainerform";

    }

}
