package be.vdab.retrovideo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController
{
    @GetMapping
    public ModelAndView index()
    {
        String boodschap = "hello world";
        return  new ModelAndView("index", "boodschap", boodschap);
    }
}
