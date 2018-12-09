// Tomáš Vopat - vopattom

package ristaurace.businessLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ristaurace.dataLayer.entities.TypEntity;
import ristaurace.dataLayer.repository.TypRepository;

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
