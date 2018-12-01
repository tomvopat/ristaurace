// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.entities.StavPolozkyEntity;
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

    @PostMapping(path="/setReady/{id}")
    public @ResponseBody String setOrderReady(@PathVariable long id) {
        return "Order set as ready";
    }

    @PostMapping(path="/setDone/{id}")
    public @ResponseBody String setOrderDone(@PathVariable long id) {
        return "Order se as done";
    }

}
