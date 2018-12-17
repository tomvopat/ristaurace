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
     * @param categoryId
     * @return
     */
    public List<PolozkaMenuEntity> getAllByCategory(Integer categoryId) {
        List<TypPolozkaMenuEntity> typPolozkaList = polozkaMenuRepository.findAllByCategory(categoryId);
        List<PolozkaMenuEntity> polozkaList = new ArrayList<>();
        for(TypPolozkaMenuEntity typPolozka : typPolozkaList ) {
            polozkaList.add(typPolozka.getPolozkaMenuByIdPolozkaMenu());
        }

        return polozkaList;
    }

    /**
     * Na zadaný účet přiřadí danou položku z menu
     * @param ucetId
     * @param itemId
     * @return
     */
    public StavPolozkyEntity orderItem(Integer ucetId, Integer itemId) {
        Optional<UcetEntity> ucetEntity = ucetRepository.findById(ucetId);
        Optional<PolozkaMenuEntity> polozkaMenuEntity = polozkaMenuRepository.findById(itemId);
        if(!ucetEntity.isPresent() || !polozkaMenuEntity.isPresent()) return null;

        StavPolozkyEntity stavPolozkyEntity = new StavPolozkyEntity();
        stavPolozkyEntity.setUcetByIdUcet(ucetEntity.get());
        stavPolozkyEntity.setPolozkaMenuByIdPolozkaMenu(polozkaMenuEntity.get());
        return stavPolozkyRepository.saveAndFlush(stavPolozkyEntity);
    }
}
