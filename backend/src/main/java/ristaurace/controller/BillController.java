// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.businessLayer.BillBusiness;
import ristaurace.dataLayer.entities.StulUcetEntity;
import ristaurace.dataLayer.entities.UcetEntity;

import java.util.List;

@Controller
@RequestMapping(path="/bill")
public class BillController {

    private final BillBusiness billBusiness;

    public BillController(BillBusiness billBusiness) {
        this.billBusiness = billBusiness;
    }

    @GetMapping(path = "/all")
    public @ResponseBody List<StulUcetEntity> getAll() {
        return billBusiness.getAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody UcetEntity getById(@PathVariable Integer id) {
        return billBusiness.getById(id);
    }

    @GetMapping(path = "/opened")
    public @ResponseBody List<StulUcetEntity> getAllOpened() {
        return billBusiness.getAllOpened();
    }

    @GetMapping(path = "/closed")
    public @ResponseBody List<StulUcetEntity> getAllClosed() {
        return billBusiness.getAllClosed();
    }

    @PostMapping(path = "/open/{bill_id}")
    public @ResponseBody StulUcetEntity setBillOpened(@PathVariable Integer bill_id) {
        return billBusiness.setBillOpened(bill_id);
    }

    @PostMapping(path = "/close/{bill_id}")
    public @ResponseBody StulUcetEntity setBillClosed(@PathVariable Integer bill_id, @RequestParam Boolean card) {
        return billBusiness.setBillClosed(bill_id, card);
    }

    @PostMapping(path = "/new/{table_id}")
    public @ResponseBody StulUcetEntity createNew(@PathVariable Integer table_id) {
        return billBusiness.createNew(table_id);
    }
}
