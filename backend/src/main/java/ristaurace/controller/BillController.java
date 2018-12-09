// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.business.BillBusiness;
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
