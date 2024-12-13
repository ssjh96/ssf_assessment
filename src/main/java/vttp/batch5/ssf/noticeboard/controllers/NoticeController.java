package vttp.batch5.ssf.noticeboard.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import vttp.batch5.ssf.noticeboard.models.Notice;


// Use this class to write your request handlers

@Controller
public class NoticeController {

    @GetMapping("/")
    public String showLandingPage(Model model) {

        Notice notice = new Notice();

        model.addAttribute("notice", notice);
        
        return "notice";
    }
    

    @PostMapping("/notice")
    public String postNotice(@Valid @ModelAttribute ("notice") Notice notice, BindingResult result, Model model) {
       
        if (result.hasErrors()) {
            return "notice"; 
        }
       
        return "redirect:/success"; 
    }

}
