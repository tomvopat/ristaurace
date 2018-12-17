// Tomáš Vopat - vopattom

package ristaurace.businessLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ristaurace.dataLayer.entities.PolozkaMenuEntity;
import ristaurace.dataLayer.entities.StavPolozkyEntity;
import ristaurace.dataLayer.entities.TypPolozkaMenuEntity;
import ristaurace.dataLayer.entities.UcetEntity;
import ristaurace.dataLayer.repository.PolozkaMenuRepository;
import ristaurace.dataLayer.repository.StavPolozkyRepository;
import ristaurace.dataLayer.repository.UcetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Tato třída implementuje business logiku pro práci s položkami na menu.
 * Stará se získávání všech položek, získávání všech položek určité kategorie a přiřazování položek z menu na nějaký účet.
 */
@Service
public class MenuItemsBusiness {
    @Autowired
    PolozkaMenuRepository polozkaMenuRepository;

    @Autowired
    UcetRepository ucetRepository;

    @Autowired
    StavPolozkyRepository stavPolozkyRepository;

    /**
     * Vrátí všechny položky v menu
     * @return
     */
    public List<PolozkaMenuEntity> getAll() {
        return polozkaMenuRepository.findAll();
    }

    /**
     * Vrátí všechny položky v menu ze zadané kategorie
     * @param category_id
     * @return
     */
    public List<PolozkaMenuEntity> getAllByCategory(Integer category_id) {
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
    public StavPolozkyEntity orderItem(Integer ucet_id, Integer item_id) {
        Optional<UcetEntity> ucetEntity = ucetRepository.findById(ucet_id);
        Optional<PolozkaMenuEntity> polozkaMenuEntity = polozkaMenuRepository.findById(item_id);
        if(!ucetEntity.isPresent() || !polozkaMenuEntity.isPresent()) return null;

        StavPolozkyEntity stavPolozkyEntity = new StavPolozkyEntity();
        stavPolozkyEntity.setUcetByIdUcet(ucetEntity.get());
        stavPolozkyEntity.setPolozkaMenuByIdPolozkaMenu(polozkaMenuEntity.get());
        return stavPolozkyRepository.saveAndFlush(stavPolozkyEntity);
    }
}
