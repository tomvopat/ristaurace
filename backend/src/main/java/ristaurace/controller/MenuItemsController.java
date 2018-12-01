// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.entities.PolozkaMenuEntity;
import ristaurace.entities.StulEntity;
import ristaurace.repository.PolozkaMenuRepository;
import ristaurace.repository.StulRepository;

import java.util.Optional;

@Controller
@RequestMapping(path="/menu-items")
public class MenuItemsController {

    private final PolozkaMenuRepository polozkaMenuRepository;
    private final StulRepository stulRepository;

    public MenuItemsController(PolozkaMenuRepository polozkaMenuRepository, StulRepository stulRepository) {
        this.polozkaMenuRepository = polozkaMenuRepository;
        this.stulRepository = stulRepository;
    }

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

    @PostMapping(path="/order/{ucet_id}/{item_id}")
    public @ResponseBody String orderItem(@PathVariable long ucet_id, @PathVariable long item_id) {

        return "Item " + item_id + " ordered to bill " + ucet_id + ".";
    }
}
