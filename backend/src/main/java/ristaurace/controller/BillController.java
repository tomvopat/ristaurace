// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.entities.StulUcetEntity;
import ristaurace.entities.UcetEntity;
import ristaurace.repository.StulUcetRepository;
import ristaurace.repository.UcetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/bill")
public class BillController {

    private final UcetRepository ucetRepository;
    private final StulUcetRepository stulUcetRepository;

    public BillController(UcetRepository ucetRepository, StulUcetRepository stulUcetRepository) {
        this.ucetRepository = ucetRepository;
        this.stulUcetRepository = stulUcetRepository;
    }

    /**
     * Vrátí všechny účty
     * @return
     */
    @GetMapping(path = "/all")
    public @ResponseBody List<UcetEntity> getAll() {
        return ucetRepository.findAll();
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

        List<StulUcetEntity> stulUcetList = stulUcetRepository.findAllOpened();

        //TODO
        List<StulUcetEntity> help = new ArrayList<>();
        for (StulUcetEntity u : stulUcetList) {
            if(u.getStav() == StulUcetEntity.StavEnum.otevreny) {
                help.add(u);
            }
        }
        stulUcetList = help;

        return stulUcetList;
    }

//    @PostMapping(path = "/new/{table_id}")
//    public @ResponseBody
//    StulUcetEntity createNew(@PathVariable Long table_id) {
//
//        UcetEntity ucetEntity = new UcetEntity();
//
//    }
}
