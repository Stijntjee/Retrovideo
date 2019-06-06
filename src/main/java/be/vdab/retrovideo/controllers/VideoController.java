package be.vdab.retrovideo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/video")
class VideoController
{
    @GetMapping
    public ModelAndView index()
    {
        String boodschap = "hello world";
        return  new ModelAndView("video", "boodschap", boodschap);
    }
}
