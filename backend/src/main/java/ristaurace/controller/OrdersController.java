// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.business.OrdersBusiness;
import ristaurace.entities.StavPolozkyEntity;
import ristaurace.helpObjects.StavEnum;
import ristaurace.repository.StavPolozkyRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/order")
public class OrdersController {

    private final OrdersBusiness ordersBusiness;

    public OrdersController(OrdersBusiness ordersBusiness) {
        this.ordersBusiness = ordersBusiness;
    }

    @GetMapping(path="/all")
    public @ResponseBody List<StavPolozkyEntity> getAllOrders() {
        return ordersBusiness.getAllOrders();
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody StavPolozkyEntity getOrder(@PathVariable Integer id) {
        return ordersBusiness.getOrder(id);
    }

    @GetMapping(path="/date/{date}")
    public @ResponseBody String getOrdersDate(@PathVariable LocalDate date) {
        return ordersBusiness.getOrdersDate(date);
    }

    @GetMapping(path="/pending")
    public @ResponseBody List<StavPolozkyEntity> getPending() {
        return ordersBusiness.getPending();
    }

    @GetMapping(path="/ready")
    public @ResponseBody List<StavPolozkyEntity> getReady() {
        return ordersBusiness.getReady();
    }

    @GetMapping(path="/closed")
    public @ResponseBody List<StavPolozkyEntity> getClosed() {
        return ordersBusiness.getClosed();
    }

    @PostMapping(path="/setOpened/{id}")
    public @ResponseBody StavPolozkyEntity setOrderOpened(@PathVariable Integer id) {
        return ordersBusiness.setOrderOpened(id);
    }

    @PostMapping(path="/setReady/{id}")
    public @ResponseBody StavPolozkyEntity setOrderReady(@PathVariable Integer id) {
        return ordersBusiness.setOrderReady(id);
    }

    @PostMapping(path="/setDone/{id}")
    public @ResponseBody StavPolozkyEntity setOrderDone(@PathVariable Integer id) {
        return ordersBusiness.setOrderDone(id);
    }

    public List<StavPolozkyEntity> setAllOrdersWithSomeBillAs(Integer ucet_id, StavEnum stav) {
        return ordersBusiness.setAllOrdersWithSomeBillAs(ucet_id, stav);
    }

    @PostMapping(path="/setAllOpened/bill/{bill_id}")
    public @ResponseBody List<StavPolozkyEntity> setAllOpened(@PathVariable Integer bill_id) {
        return ordersBusiness.setAllOpened(bill_id);
    }

    @PostMapping(path="/setAllReady/bill/{bill_id}")
    public @ResponseBody List<StavPolozkyEntity> setAllReady(@PathVariable Integer bill_id) {
        return ordersBusiness.setAllReady(bill_id);
    }

    @PostMapping(path="/setAllClosed/bill/{bill_id}")
    public @ResponseBody List<StavPolozkyEntity> setAllClosed(@PathVariable Integer bill_id) {
        return ordersBusiness.setAllClosed(bill_id);
    }

}
