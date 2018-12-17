// Tomáš Vopat - vopattom

package ristaurace.businessLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ristaurace.dataLayer.entities.StulEntity;
import ristaurace.dataLayer.repository.StulRepository;

import java.util.List;

/**
 * Tato třída implementuje business logiku pro spravování stolů
 * Stará se o vracení všech stolů, které jsou k dispozici.
 */
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
