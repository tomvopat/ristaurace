// Tomáš Vopat - vopattom

package ristaurace.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ristaurace.entities.PolozkaMenuEntity;
import ristaurace.entities.StavPolozkyEntity;
import ristaurace.entities.TypPolozkaMenuEntity;
import ristaurace.entities.UcetEntity;
import ristaurace.repository.PolozkaMenuRepository;
import ristaurace.repository.StavPolozkyRepository;
import ristaurace.repository.UcetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
