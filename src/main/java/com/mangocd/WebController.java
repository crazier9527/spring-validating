package com.mangocd;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by Ryan on 2017/6/15.
 */
@Controller
public class WebController {

    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results.html?a=b";
    }



    @GetMapping("/ill")
    public String ill(PersonForm personForm) {
        throw new IllegalArgumentException("参数不全");
    }

    @GetMapping("/run")
    public String run(PersonForm personForm) {
        throw new RuntimeException();
    }

    @ResponseBody
    @GetMapping("/rest")
    public String rest(@Valid PersonForm personForm) {//BindingResult bindingResult
//        if (bindingResult.hasErrors()) {
//            Log.info("has errors");
//            return "form";
//        }

        return personForm.toString();
    }


}