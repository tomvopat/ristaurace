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

    /**
     * Vrátí všechny čekající objednávky
     * @return
     */
    @GetMapping(path="/pending")
    public @ResponseBody List<StavPolozkyEntity> getPending() {
        return stavPolozkyRepository.findAllPending();
    }

    /**
     * Vrátí všechny objednávky připravené k výdeji
     * @return
     */
    @GetMapping(path="/ready")
    public @ResponseBody List<StavPolozkyEntity> getReady() {
        return stavPolozkyRepository.findAllReady();
    }

    /**
     * Vrátí všechny vydané objednávky
     * @return
     */
    @GetMapping(path="/closed")
    public @ResponseBody List<StavPolozkyEntity> getClosed() {
        return stavPolozkyRepository.findAllClosed();
    }

    public StavPolozkyEntity setOrderAs(Integer orderId, StavEnum stav) {
        Optional<StavPolozkyEntity> stavPolozkyOptional = stavPolozkyRepository.findById(orderId);
        if(!stavPolozkyOptional.isPresent()) return null;
        StavPolozkyEntity stavPolozky = stavPolozkyOptional.get();
        stavPolozky.setStav(stav);
        return stavPolozkyRepository.saveAndFlush(stavPolozky);
    }

    /**
     * Otevře starou objednávku
     * @param id
     * @return
     */
    @PostMapping(path="/setOpened/{id}")
    public @ResponseBody StavPolozkyEntity setOrderOpened(@PathVariable Integer id) {
        return setOrderAs(id, StavEnum.otevreny);
    }

    /**
     * Nastaví objednávku jako připravenou k výdeji
     * @param id
     * @return
     */
    @PostMapping(path="/setReady/{id}")
    public @ResponseBody StavPolozkyEntity setOrderReady(@PathVariable Integer id) {
        return setOrderAs(id, StavEnum.pripraveny);
    }

    /**
     * Označí objednávku jako vydanou
     * @param id
     * @return
     */
    @PostMapping(path="/setDone/{id}")
    public @ResponseBody StavPolozkyEntity setOrderDone(@PathVariable Integer id) {
        return setOrderAs(id, StavEnum.zavreny);
    }

    public List<StavPolozkyEntity> setAllOrdersWithSomeBillAs(Integer ucet_id, StavEnum stav) {
        List<StavPolozkyEntity> stavPolozkyEntityList = stavPolozkyRepository.findAllWithBill(ucet_id);
        for(StavPolozkyEntity stavPolozky : stavPolozkyEntityList) {
            stavPolozky.setStav(stav);
        }
        stavPolozkyRepository.saveAll(stavPolozkyEntityList);
        return stavPolozkyEntityList;
    }

    /**
     * Nastavý všechny položky u daného účtu jako otevřené
     * @param bill_id
     * @return
     */
    @PostMapping(path="/setAllOpened/bill/{bill_id}")
    public @ResponseBody List<StavPolozkyEntity> setAllOpened(@PathVariable Integer bill_id) {
        return setAllOrdersWithSomeBillAs(bill_id, StavEnum.otevreny);
    }

    /**
     * Nastaví všechny položky u daného účtu jako připravené
     * @param bill_id
     * @return
     */
    @PostMapping(path="/setAllReady/bill/{bill_id}")
    public @ResponseBody List<StavPolozkyEntity> setAllReady(@PathVariable Integer bill_id) {
        return setAllOrdersWithSomeBillAs(bill_id, StavEnum.pripraveny);
    }

    /**
     * Nastaví všechny položky u daného účtu jako zavřené
     * @param bill_id
     * @return
     */
    @PostMapping(path="/setAllClosed/bill/{bill_id}")
    public @ResponseBody List<StavPolozkyEntity> setAllClosed(@PathVariable Integer bill_id) {
        return setAllOrdersWithSomeBillAs(bill_id, StavEnum.zavreny);
    }

}
