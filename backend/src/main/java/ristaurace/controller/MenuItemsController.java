// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/menu-items")
public class MenuItemsController {

    @GetMapping(path="/daily")
    public @ResponseBody String getDailyMenu() {
        return "Daily menu";
    }

    @GetMapping(path="/permanent")
    public @ResponseBody String getPermanentMenu() {
        return "Permanent menu";
    }

    @GetMapping(path="/drinks")
    public @ResponseBody String getDrinks() {
        return "Drinks";
    }

    @PostMapping(path="/order")
    public @ResponseBody String orderItem(@RequestParam long item_id) {
        return "Item ordered.";
    }
}
