// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ristaurace.business.TypeBusiness;
import ristaurace.entities.TypEntity;
import ristaurace.repository.TypRepository;

import java.util.List;

@Controller
@RequestMapping(path = "/type")
public class TypeController {

    private final TypeBusiness typeBusiness;

    public TypeController(TypeBusiness typeBusiness) {
        this.typeBusiness = typeBusiness;
    }

    @GetMapping(path = "/all")
    public @ResponseBody List<TypEntity> getAll() {
        return typeBusiness.getAll();
    }
}
