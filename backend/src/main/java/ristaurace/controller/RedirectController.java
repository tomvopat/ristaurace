//Petr Eryukov — eryukpet
package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RedirectController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectExample(HttpServletRequest request) {
        return "redirect:" + request.getScheme() +request.getRequestURL()+ "home";
    }
}