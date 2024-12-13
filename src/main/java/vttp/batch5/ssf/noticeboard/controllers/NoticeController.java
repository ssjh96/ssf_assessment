package vttp.batch5.ssf.noticeboard.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import vttp.batch5.ssf.noticeboard.models.Notice;
import vttp.batch5.ssf.noticeboard.services.NoticeService;


// Use this class to write your request handlers

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/")
    public String showLandingPage(Model model) {

        Notice notice = new Notice();

        model.addAttribute("notice", notice);
        
        return "notice";
    }
    

    @PostMapping("/notice")
    public String postNotice(@Valid @ModelAttribute ("notice") Notice notice, BindingResult bindingResult, Model model) {
       
        if (bindingResult.hasErrors()) {
            return "notice"; 
        }
       
        List<String> respList = noticeService.postToNoticeServer(notice);

        System.out.println(respList.get(0));
        System.out.println(respList.get(1));
        
        if(respList.get(0).startsWith("id"))
        {
            model.addAttribute("respId", respList.get(0));

            return "success";
        }
        else
        {
            model.addAttribute("error", respList.get(0));

            return "error";
        }
    }

}
