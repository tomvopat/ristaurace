// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ristaurace.entities.TypEntity;
import ristaurace.repository.TypRepository;

import java.util.List;

@Controller
@RequestMapping(path = "/type")
public class TypeController {

    TypRepository typRepository;

    public TypeController(TypRepository typRepository) {
        this.typRepository = typRepository;
    }

    /**
     * Vrátí všechny dostupné typy jídel
     * @return
     */
    @GetMapping(path = "/all")
    public @ResponseBody List<TypEntity> getAll() {
        return typRepository.findAll();
    }
}
