package com.DBEample.SQLDBDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class DemoController {

    @GetMapping("/")
    public String showHomePage(Model theModel){
        return "index";
    }

    @GetMapping("/addnews")
    public String addNewsPage(Model theModel){
        return "addnews";
    }


}
