// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    private final PolozkaMenuRepository polozkaMenuRepository;
    private final UcetRepository ucetRepository;
    private final StavPolozkyRepository stavPolozkyRepository;

    public MenuItemsController(PolozkaMenuRepository polozkaMenuRepository, UcetRepository ucetRepository, StavPolozkyRepository stavPolozkyRepository) {
        this.polozkaMenuRepository = polozkaMenuRepository;
        this.ucetRepository = ucetRepository;
        this.stavPolozkyRepository = stavPolozkyRepository;
    }

    /**
     * Vrátí všechny položky v menu
     * @return
     */
    @GetMapping(path="/")
    public @ResponseBody List<PolozkaMenuEntity> getAll() {
        return polozkaMenuRepository.findAll();
    }

    /**
     * Vrátí všechny položky v menu ze zadané kategorie
     * @param category_id
     * @return
     */
    @GetMapping(path="/category/{category_id}")
    public @ResponseBody List<PolozkaMenuEntity> getAllByCategory(@PathVariable Integer category_id) {
        List<TypPolozkaMenuEntity> typPolozkaList = polozkaMenuRepository.findAllByCategory(category_id);
        List<PolozkaMenuEntity> polozkaList = new ArrayList<>();
        for(TypPolozkaMenuEntity typPolozka : typPolozkaList ) {
            polozkaList.add(typPolozka.getPolozkaMenuByIdPolozkaMenu());
        }

        return polozkaList;
    }

    /**
     * Na zadaný účet přiřadí danou položku z menu
     * @param ucet_id
     * @param item_id
     * @return
     */
    @PostMapping(path="/order/{ucet_id}/{item_id}")
    public @ResponseBody StavPolozkyEntity orderItem(@PathVariable Integer ucet_id, @PathVariable Integer item_id) {
        Optional<UcetEntity> ucetEntity = ucetRepository.findById(ucet_id);
        Optional<PolozkaMenuEntity> polozkaMenuEntity = polozkaMenuRepository.findById(item_id);
        if(!ucetEntity.isPresent() || !polozkaMenuEntity.isPresent()) return null;

        StavPolozkyEntity stavPolozkyEntity = new StavPolozkyEntity();
        stavPolozkyEntity.setUcetByIdUcet(ucetEntity.get());
        stavPolozkyEntity.setPolozkaMenuByIdPolozkaMenu(polozkaMenuEntity.get());
        return stavPolozkyRepository.saveAndFlush(stavPolozkyEntity);
    }
}
