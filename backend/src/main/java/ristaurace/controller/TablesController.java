// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ristaurace.businessLayer.TablesBusiness;
import ristaurace.dataLayer.entities.StulEntity;

import java.util.List;

/**
 * Tato třída postkytuje REST api pro práci se stoly.
 * Stará se o vracení všech dostupných stolů.
 */
@Controller
@RequestMapping(path="/tables")
public class TablesController {

    private final TablesBusiness tablesBusiness;

    public TablesController(TablesBusiness tablesBusiness) {
        this.tablesBusiness = tablesBusiness;
    }

    /**
     * Vrátí list všech stolů v restauraci.
     * @return
     */
    @GetMapping(path="/all")
    public @ResponseBody List<StulEntity> getTables() {
        return tablesBusiness.getTables();
    }
}
