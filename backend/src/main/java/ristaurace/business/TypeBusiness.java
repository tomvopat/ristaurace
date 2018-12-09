// Tomáš Vopat - vopattom

package ristaurace.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ristaurace.entities.TypEntity;
import ristaurace.repository.TypRepository;

import java.util.List;

@Service
public class TypeBusiness {

    @Autowired
    TypRepository typRepository;

    /**
     * Vrátí všechny dostupné typy jídel
     * @return
     */
    public List<TypEntity> getAll() {
        return typRepository.findAll();
    }
}
