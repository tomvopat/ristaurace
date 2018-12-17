// Tomáš Vopat - vopattom

package ristaurace.businessLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ristaurace.dataLayer.entities.StulEntity;
import ristaurace.dataLayer.entities.StulUcetEntity;
import ristaurace.dataLayer.entities.UcetEntity;
import ristaurace.dataLayer.helpObjects.StavEnum;
import ristaurace.dataLayer.repository.StulRepository;
import ristaurace.dataLayer.repository.StulUcetRepository;
import ristaurace.dataLayer.repository.UcetRepository;

import java.util.List;
import java.util.Optional;

/**
 * Tato třída implementuje business logiku pro účty od zákazníků.
 * Stará se o získávání aktuálních účtů, vytváření nových a změnu jejich stavu.
 */
@Service
public class BillBusiness {

    @Autowired
    UcetRepository ucetRepository;

    @Autowired
    StulRepository stulRepository;

    @Autowired
    StulUcetRepository stulUcetRepository;


    /**
     * Vrátí všechny účty
     * @return
     */
    public List<StulUcetEntity> getAll() {
        return stulUcetRepository.findAll();
    }

    /**
     * Vrátí účet podle zadaného id
     * @param id
     * @return
     */
    public UcetEntity getById(Integer id) {
        Optional<UcetEntity> ucetEntity = ucetRepository.findById(id);
        if(ucetEntity.isPresent()) {
            return ucetEntity.get();
        }
        else {
            return null;
        }
    }

    /**
     * Vrátí všechny otevřené účty
     * @return
     */
    public List<StulUcetEntity> getAllOpened() {
        return stulUcetRepository.findAllOpened();
    }

    /**
     * Vrátí všechny uzavřené účty
     * @return
     */
    public List<StulUcetEntity> getAllClosed() {
        return stulUcetRepository.findAllClosed();
    }

    /**
     * Pro účet zadaný identifikátorem nastaví určitý stav
     * @param id
     * @param stav
     * @return
     */
    private StulUcetEntity setState(Integer id, StavEnum stav) {
        if(stav == StavEnum.pripraveny) return null;

        Optional<StulUcetEntity> stulUcetOptional = stulUcetRepository.findById(id);
        if(!stulUcetOptional.isPresent()) return null;

        StulUcetEntity stulUcet = stulUcetOptional.get();
        stulUcet.setStav(stav);
        return stulUcetRepository.saveAndFlush(stulUcet);
    }


    /**
     * Otevře starý účet
     * @param billId
     * @return
     */
    public StulUcetEntity setBillOpened(Integer billId) {
        return setState(billId, StavEnum.otevreny);
    }

    /**
     * Uzavře účet
     * @param billId
     * @param card
     * @return
     */
    public StulUcetEntity setBillClosed(Integer billId, Boolean card) {
        StulUcetEntity stulUcetEntity = setState(billId, StavEnum.zavreny);
        stulUcetEntity.getUcetByIdUcet().setPlatbaKartou(card);
        return stulUcetRepository.save(stulUcetEntity);
    }

    /**
     * Vytvoří nový účet k danému stolu
     * @param tableId
     * @return
     */
    public StulUcetEntity createNew(Integer tableId) {

        Optional<StulEntity> stulEntityOptional = stulRepository.findById(tableId);
        if(!stulEntityOptional.isPresent()) return null;


        UcetEntity ucetEntity = new UcetEntity();
        ucetRepository.save(ucetEntity);

        StulUcetEntity stulUcetEntity = new StulUcetEntity();
        stulUcetEntity.setStulByIdStul(stulEntityOptional.get());
        stulUcetEntity.setUcetByIdUcet(ucetEntity);
        return stulUcetRepository.saveAndFlush(stulUcetEntity);
    }

}
