// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ristaurace.businessLayer.BillBusiness;
import ristaurace.dataLayer.entities.StulUcetEntity;
import ristaurace.dataLayer.entities.UcetEntity;

import java.util.List;

/**
 * Tato třída poskytuje REST api pro práci s účty.
 * Stará se o získávání všech účtů, podle zadaného id, nastavování statusu účtu nebo vytváření nového účtu.
 */
@Controller
@RequestMapping(path="/bill")
public class BillController {

    private final BillBusiness billBusiness;

    public BillController(BillBusiness billBusiness) {
        this.billBusiness = billBusiness;
    }

    /**
     * Vrátí všechny účty, které jsou přiřazené nějakému stolu.
     * @return
     */
    @GetMapping(path = "/all")
    public @ResponseBody List<StulUcetEntity> getAll() {
        return billBusiness.getAll();
    }

    /**
     * Vrátí účet podle zadaného identifikátoru.
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public @ResponseBody UcetEntity getById(@PathVariable Integer id) {
        return billBusiness.getById(id);
    }

    /**
     * Vrátí všechny účty, které jsou ve stavu "otevřený".
     * @return
     */
    @GetMapping(path = "/opened")
    public @ResponseBody List<StulUcetEntity> getAllOpened() {
        return billBusiness.getAllOpened();
    }

    /**
     * Vrátí všechny účty, které jsou ve stavu "zavřený".
     * @return
     */
    @GetMapping(path = "/closed")
    public @ResponseBody List<StulUcetEntity> getAllClosed() {
        return billBusiness.getAllClosed();
    }

    /**
     * Nastaví stav "otevřený" účtu zadanému identifikátorem.
     * @param billId
     * @return účet se změněným stavem
     */
    @PostMapping(path = "/open/{billId}")
    public @ResponseBody StulUcetEntity setBillOpened(@PathVariable Integer billId) {
        return billBusiness.setBillOpened(billId);
    }

    /**
     * Nastaví stav "zavřený" účtu zadanému identifikátorem.
     * @param billId
     * @param card
     * @return účet se změněným stavem
     */
    @PostMapping(path = "/close/{billId}")
    public @ResponseBody StulUcetEntity setBillClosed(@PathVariable Integer billId, @RequestParam Boolean card) {
        return billBusiness.setBillClosed(billId, card);
    }

    /**
     * Vytvoří nový účet, který je přiřazen stolu zadanému identifikátorem.
     * @param tableId
     * @return nově vytvořený účet.
     */
    @PostMapping(path = "/new/{tableId}")
    public @ResponseBody StulUcetEntity createNew(@PathVariable Integer tableId) {
        return billBusiness.createNew(tableId);
    }
}
