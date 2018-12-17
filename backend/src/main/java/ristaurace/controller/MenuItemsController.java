// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.businessLayer.MenuItemsBusiness;
import ristaurace.dataLayer.entities.PolozkaMenuEntity;
import ristaurace.dataLayer.entities.StavPolozkyEntity;

import java.util.List;

/**
 * Tato třída poskytuje REST api pro práci s položkami v menu.
 * Stará se o získání položek menu, získávání položek určité kategorie, přiřazování položek menu na zadaný účet.
 */
@Controller
@RequestMapping(path="/menu-items")
public class MenuItemsController {

    private final MenuItemsBusiness menuItemsBusiness;

    public MenuItemsController(MenuItemsBusiness menuItemsBusiness) {
        this.menuItemsBusiness = menuItemsBusiness;
    }

    /**
     * Vrátí list všech položek menu.
     * @return
     */
    @GetMapping(path="/")
    public @ResponseBody List<PolozkaMenuEntity> getAll() {
        return menuItemsBusiness.getAll();
    }


    /**
     * Vrátí list všech položek menu podle zadané kategorie.
     * @param categoryId
     * @return
     */
    @GetMapping(path="/category/{categoryId}")
    public @ResponseBody List<PolozkaMenuEntity> getAllByCategory(@PathVariable Integer categoryId) {
        return menuItemsBusiness.getAllByCategory(categoryId);
    }

    /**
     * Přiřadí položku z menu na účet zadaný identifikátorem
     * @param ucetId
     * @param itemId
     * @return Položka přiřazená na účet
     */
    @PostMapping(path="/order/{ucetId}/{itemId}")
    public @ResponseBody StavPolozkyEntity orderItem(@PathVariable Integer ucetId, @PathVariable Integer itemId) {
        return menuItemsBusiness.orderItem(ucetId, itemId);
    }
}
