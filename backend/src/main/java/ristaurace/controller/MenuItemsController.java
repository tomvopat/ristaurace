// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.business.MenuItemsBusiness;
import ristaurace.entities.PolozkaMenuEntity;
import ristaurace.entities.StavPolozkyEntity;
import ristaurace.entities.TypPolozkaMenuEntity;
import ristaurace.entities.UcetEntity;
import ristaurace.repository.PolozkaMenuRepository;
import ristaurace.repository.StavPolozkyRepository;
import ristaurace.repository.StulRepository;
import ristaurace.repository.UcetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/menu-items")
public class MenuItemsController {

    private final MenuItemsBusiness menuItemsBusiness;

    public MenuItemsController(MenuItemsBusiness menuItemsBusiness) {
        this.menuItemsBusiness = menuItemsBusiness;
    }

    @GetMapping(path="/")
    public @ResponseBody List<PolozkaMenuEntity> getAll() {
        return menuItemsBusiness.getAll();
    }


    @GetMapping(path="/category/{category_id}")
    public @ResponseBody List<PolozkaMenuEntity> getAllByCategory(@PathVariable Integer category_id) {
        return menuItemsBusiness.getAllByCategory(category_id);
    }

    @PostMapping(path="/order/{ucet_id}/{item_id}")
    public @ResponseBody StavPolozkyEntity orderItem(@PathVariable Integer ucet_id, @PathVariable Integer item_id) {
        return menuItemsBusiness.orderItem(ucet_id, item_id);
    }
}
