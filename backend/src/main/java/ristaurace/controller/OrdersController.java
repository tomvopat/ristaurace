// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.entities.StavPolozkyEntity;
import ristaurace.helpObjects.StavEnum;
import ristaurace.repository.StavPolozkyRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/order")
public class OrdersController {

    private StavPolozkyRepository stavPolozkyRepository;

    public OrdersController(StavPolozkyRepository stavPolozkyRepository) {
        this.stavPolozkyRepository = stavPolozkyRepository;
    }

    /**
     * Vrátí všechny objednané položky
     * @return
     */
    @GetMapping(path="/all")
    public @ResponseBody List<StavPolozkyEntity> getAllOrders() {
        return stavPolozkyRepository.findAll();
    }

    /**
     * Vrátí objednanou položku se zadaným id
     * @param id
     * @return
     */
    @GetMapping(path="/id/{id}")
    public @ResponseBody StavPolozkyEntity getOrder(@PathVariable Integer id) {
        Optional<StavPolozkyEntity> stavPolozky =  stavPolozkyRepository.findById(id);
        if(!stavPolozky.isPresent()) return null;
        return stavPolozky.get();
    }

    @GetMapping(path="/date/{date}")
    public @ResponseBody String getOrdersDate(@PathVariable LocalDate date) {
        return "All orders on date.";
    }

    @GetMapping(path="/pending")
    public @ResponseBody String getOrdersPending() {
        return "Pending orders.";
    }

    public StavPolozkyEntity setOrderAs(Integer orderId, StavEnum stav) {
        Optional<StavPolozkyEntity> stavPolozkyOptional = stavPolozkyRepository.findById(orderId);
        if(!stavPolozkyOptional.isPresent()) return null;
        StavPolozkyEntity stavPolozky = stavPolozkyOptional.get();
        stavPolozky.setStav(stav);
        return stavPolozkyRepository.saveAndFlush(stavPolozky);
    }

    @PostMapping(path="/setOpened/{id}")
    public @ResponseBody StavPolozkyEntity setOrderOpened(@PathVariable Integer id) {
        return setOrderAs(id, StavEnum.otevreny);
    }

    @PostMapping(path="/setReady/{id}")
    public @ResponseBody StavPolozkyEntity setOrderReady(@PathVariable Integer id) {
        return setOrderAs(id, StavEnum.pripraveny);
    }

    @PostMapping(path="/setDone/{id}")
    public @ResponseBody StavPolozkyEntity setOrderDone(@PathVariable Integer id) {
        return setOrderAs(id, StavEnum.zavreny);
    }

}
