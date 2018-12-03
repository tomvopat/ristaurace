// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.entities.StulEntity;
import ristaurace.entities.StulUcetEntity;
import ristaurace.entities.UcetEntity;
import ristaurace.helpObjects.StavEnum;
import ristaurace.repository.StulRepository;
import ristaurace.repository.StulUcetRepository;
import ristaurace.repository.UcetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/bill")
public class BillController {

    private final UcetRepository ucetRepository;
    private final StulRepository stulRepository;
    private final StulUcetRepository stulUcetRepository;

    public BillController(UcetRepository ucetRepository, StulRepository stulRepository, StulUcetRepository stulUcetRepository) {
        this.ucetRepository = ucetRepository;
        this.stulRepository = stulRepository;
        this.stulUcetRepository = stulUcetRepository;
    }

    /**
     * Vrátí všechny účty
     * @return
     */
    @GetMapping(path = "/all")
    public @ResponseBody List<StulUcetEntity> getAll() {
        return stulUcetRepository.findAll();
    }

    /**
     * Vrátí účet podle zadaného id
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public @ResponseBody UcetEntity getById(@PathVariable Integer id) {
        Optional<UcetEntity> ucetEntity = ucetRepository.findById(id);
        if(ucetEntity.isPresent()) {
            return ucetEntity.get();
        }
        else {
            return null;
        }
    }

    /**
     * Vrátí všechny otevřené účty
     * @return
     */
    @GetMapping(path = "/opened")
    public @ResponseBody List<StulUcetEntity> getAllOpened() {
        return stulUcetRepository.findAllOpened();
    }

    /**
     * Vrátí všechny uzavřené účty
     * @return
     */
    @GetMapping(path = "/closed")
    public @ResponseBody List<StulUcetEntity> getAllClosed() {
        return stulUcetRepository.findAllClosed();
    }

    private StulUcetEntity setState(Integer id, StavEnum stav) {
        if(stav == StavEnum.pripraveny) return null;

        Optional<StulUcetEntity> stulUcetOptional = stulUcetRepository.findById(id);
        if(!stulUcetOptional.isPresent()) return null;

        StulUcetEntity stulUcet = stulUcetOptional.get();
        stulUcet.setStav(stav);
        return stulUcetRepository.saveAndFlush(stulUcet);
    }


    /**
     * Otevře starý účet
     * @param bill_id
     * @return
     */
    @PostMapping(path = "/open/{bill_id}")
    public @ResponseBody StulUcetEntity setBillOpened(@PathVariable Integer bill_id) {
        return setState(bill_id, StavEnum.otevreny);
    }

    /**
     * Uzavře účet
     * @param bill_id
     * @param card
     * @return
     */
    @PostMapping(path = "/close/{bill_id}")
    public @ResponseBody StulUcetEntity setBillClosed(@PathVariable Integer bill_id, @RequestParam Boolean card) {
        StulUcetEntity stulUcetEntity = setState(bill_id, StavEnum.zavreny);
        stulUcetEntity.getUcetByIdUcet().setPlatbaKartou(card);
        return stulUcetRepository.save(stulUcetEntity);
    }

    /**
     * Vytvoří nový účet k danému stolu
     * @param table_id
     * @return
     */
    @PostMapping(path = "/new/{table_id}")
    public @ResponseBody StulUcetEntity createNew(@PathVariable Integer table_id) {

        Optional<StulEntity> stulEntityOptional = stulRepository.findById(table_id);
        if(!stulEntityOptional.isPresent()) return null;


        UcetEntity ucetEntity = new UcetEntity();
        ucetRepository.save(ucetEntity);

        StulUcetEntity stulUcetEntity = new StulUcetEntity();
        stulUcetEntity.setStulByIdStul(stulEntityOptional.get());
        stulUcetEntity.setUcetByIdUcet(ucetEntity);
        return stulUcetRepository.saveAndFlush(stulUcetEntity);
    }
}
