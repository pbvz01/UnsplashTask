package com.pbvz.app.unsplash.controller;

import com.pbvz.app.unsplash.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private PhotoService photoService;

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("photos", photoService.getPhotos());
        return "index";
    }
}
