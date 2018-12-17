// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ristaurace.businessLayer.TypeBusiness;
import ristaurace.dataLayer.entities.TypEntity;

import java.util.List;

/**
 * Tato třída postkytuje REST api pro práci s typy položek menu.
 * Stará se o získání všech typů.
 */
@Controller
@RequestMapping(path = "/type")
public class TypeController {

    private final TypeBusiness typeBusiness;

    public TypeController(TypeBusiness typeBusiness) {
        this.typeBusiness = typeBusiness;
    }

    /**
     * Vrátí seznam všech typů položek menu.
     * @return
     */
    @GetMapping(path = "/all")
    public @ResponseBody List<TypEntity> getAll() {
        return typeBusiness.getAll();
    }
}
