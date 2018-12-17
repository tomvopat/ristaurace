//Petr Eryukov — eryukpet
package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Tato třída se stará o přesměrování clienta na domovskou stránku (index.html)
 */
@Controller
public class RedirectController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectExample(HttpServletRequest request) {
        return "redirect:" + request.getRequestURL() + "index.html";
    }
}