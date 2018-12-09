// Tomáš Vopat - vopattom

package ristaurace.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ristaurace.entities.StulEntity;
import ristaurace.repository.StulRepository;

import java.util.List;

@Service
public class TablesBusiness {

    @Autowired
    StulRepository repository;

    /**
     * Vrátí všechny stoly v restauraci
     * @return
     */
    public List<StulEntity> getTables() {
        return repository.findAll();
    }
}
