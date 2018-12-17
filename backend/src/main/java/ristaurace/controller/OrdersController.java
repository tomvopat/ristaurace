// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.businessLayer.OrdersBusiness;
import ristaurace.dataLayer.entities.StavPolozkyEntity;
import ristaurace.dataLayer.helpObjects.StavEnum;

import java.time.LocalDate;
import java.util.List;

/**
 * Tato třída poskytuje REST api pro práci s objednávkami.
 * Stará se získání všech objednávek, získání položek s určitým stavem, změnu stavu určité položky.
 */
@Controller
@RequestMapping(path="/order")
public class OrdersController {

    private final OrdersBusiness ordersBusiness;

    public OrdersController(OrdersBusiness ordersBusiness) {
        this.ordersBusiness = ordersBusiness;
    }

    /**
     * Vrátí list všech objednaných položek.
     * @return
     */
    @GetMapping(path="/all")
    public @ResponseBody List<StavPolozkyEntity> getAllOrders() {
        return ordersBusiness.getAllOrders();
    }

    /**
     * Vrátí objednou položku podle zadaného id.
     * @param id
     * @return
     */
    @GetMapping(path="/id/{id}")
    public @ResponseBody StavPolozkyEntity getOrder(@PathVariable Integer id) {
        return ordersBusiness.getOrder(id);
    }

    /**
     * Vrátí seznam položek, které mají stav "otevřený".
     * @return
     */
    @GetMapping(path="/pending")
    public @ResponseBody List<StavPolozkyEntity> getPending() {
        return ordersBusiness.getPending();
    }

    /**
     * Vrátí seznam položek, které mají stav "přípravený"
     * @return
     */
    @GetMapping(path="/ready")
    public @ResponseBody List<StavPolozkyEntity> getReady() {
        return ordersBusiness.getReady();
    }

    /**
     * Vrátí seznam položek, který mají stav "zavřený".
     * @return
     */
    @GetMapping(path="/closed")
    public @ResponseBody List<StavPolozkyEntity> getClosed() {
        return ordersBusiness.getClosed();
    }

    /**
     * Nastavý stav "otevřený" objednávce podle zadaného id.
     * @param id
     * @return
     */
    @PostMapping(path="/setOpened/{id}")
    public @ResponseBody StavPolozkyEntity setOrderOpened(@PathVariable Integer id) {
        return ordersBusiness.setOrderOpened(id);
    }

    /**
     * Nastavý stav "připravený" objednávce podle zadaného id.
     * @param id
     * @return
     */
    @PostMapping(path="/setReady/{id}")
    public @ResponseBody StavPolozkyEntity setOrderReady(@PathVariable Integer id) {
        return ordersBusiness.setOrderReady(id);
    }

    /**
     * Nastavý stav "zavřený" objednávce podle zadaného id.
     * @param id
     * @return
     */
    @PostMapping(path="/setDone/{id}")
    public @ResponseBody StavPolozkyEntity setOrderDone(@PathVariable Integer id) {
        return ordersBusiness.setOrderDone(id);
    }

    /**
     * Nastaví stav "otevřený" všem položkám na účtu zadaným identifikátorem.
     * @param billId
     * @return
     */
    @PostMapping(path="/setAllOpened/bill/{billId}")
    public @ResponseBody List<StavPolozkyEntity> setAllOpened(@PathVariable Integer billId) {
        return ordersBusiness.setAllOpened(billId);
    }

    /**
     * Nastaví stav "připravený" všem položkám na účtu zadaným identifikátorem.
     * @param billId
     * @return
     */
    @PostMapping(path="/setAllReady/bill/{billId}")
    public @ResponseBody List<StavPolozkyEntity> setAllReady(@PathVariable Integer billId) {
        return ordersBusiness.setAllReady(billId);
    }

    /**
     * Nastaví stav "zavřený" všem položkám na účtu zadaným identifikátorem.
     * @param billId
     * @return
     */
    @PostMapping(path="/setAllClosed/bill/{billId}")
    public @ResponseBody List<StavPolozkyEntity> setAllClosed(@PathVariable Integer billId) {
        return ordersBusiness.setAllClosed(billId);
    }

}
