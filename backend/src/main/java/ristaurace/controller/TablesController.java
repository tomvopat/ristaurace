// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ristaurace.entities.StulEntity;
import ristaurace.repository.StulRepository;

import java.util.List;

@Controller
@RequestMapping(path="/tables")
public class TablesController {

    private final StulRepository repository;

    public TablesController(StulRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path="/all")
    public @ResponseBody
    List<StulEntity> getTables() {
        return repository.findAll();
    }
}
