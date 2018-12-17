// Tomáš Vopat - vopattom

package ristaurace.businessLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ristaurace.dataLayer.entities.StavPolozkyEntity;
import ristaurace.dataLayer.helpObjects.StavEnum;
import ristaurace.dataLayer.repository.StavPolozkyRepository;

import java.util.List;
import java.util.Optional;

/**
 * Tato třída implementuje logiku pro práci s objednávkami.
 * Stará se o získávání všech aktuálně objednaných položek, získání čekajících objednávek a změnu stavu nějaké objednávky.
 */
@Service
public class OrdersBusiness {

    @Autowired
    StavPolozkyRepository stavPolozkyRepository;

    /**
     * Vrátí všechny objednané položky
     * @return
     */
    public List<StavPolozkyEntity> getAllOrders() {
        return stavPolozkyRepository.findAll();
    }

    /**
     * Vrátí objednanou položku se zadaným id
     * @param id
     * @return
     */
    public StavPolozkyEntity getOrder(Integer id) {
        Optional<StavPolozkyEntity> stavPolozky =  stavPolozkyRepository.findById(id);
        if(!stavPolozky.isPresent()) return null;
        return stavPolozky.get();
    }

    /**
     * Vrátí všechny čekající objednávky
     * @return
     */
    public List<StavPolozkyEntity> getPending() {
        return stavPolozkyRepository.findAllPending();
    }

    /**
     * Vrátí všechny objednávky připravené k výdeji
     * @return
     */
    public List<StavPolozkyEntity> getReady() {
        return stavPolozkyRepository.findAllReady();
    }

    /**
     * Vrátí všechny vydané objednávky
     * @return
     */
    public List<StavPolozkyEntity> getClosed() {
        return stavPolozkyRepository.findAllClosed();
    }

    /**
     * Nastaví určitý stav položce podle zadaného identifikátoru
     * @param orderId
     * @param stav
     * @return
     */
    public StavPolozkyEntity setOrderAs(Integer orderId, StavEnum stav) {
        Optional<StavPolozkyEntity> stavPolozkyOptional = stavPolozkyRepository.findById(orderId);
        if(!stavPolozkyOptional.isPresent()) return null;
        StavPolozkyEntity stavPolozky = stavPolozkyOptional.get();
        stavPolozky.setStav(stav);
        return stavPolozkyRepository.saveAndFlush(stavPolozky);
    }

    /**
     * Otevře starou objednávku
     * @param id
     * @return
     */
    public StavPolozkyEntity setOrderOpened(Integer id) {
        return setOrderAs(id, StavEnum.otevreny);
    }

    /**
     * Nastaví objednávku jako připravenou k výdeji
     * @param id
     * @return
     */
    public StavPolozkyEntity setOrderReady(Integer id) {
        return setOrderAs(id, StavEnum.pripraveny);
    }

    /**
     * Označí objednávku jako vydanou
     * @param id
     * @return
     */
    public StavPolozkyEntity setOrderDone(Integer id) {
        return setOrderAs(id, StavEnum.zavreny);
    }

    /**
     * Nastaví všem položkám z účtu, který je zadán identifikátorem, nějaký stav.
     * @param ucetId
     * @param stav
     * @return
     */
    public List<StavPolozkyEntity> setAllOrdersWithSomeBillAs(Integer ucetId, StavEnum stav) {
        List<StavPolozkyEntity> stavPolozkyEntityList = stavPolozkyRepository.findAllWithBill(ucetId);
        for(StavPolozkyEntity stavPolozky : stavPolozkyEntityList) {
            stavPolozky.setStav(stav);
        }
        stavPolozkyRepository.saveAll(stavPolozkyEntityList);
        return stavPolozkyEntityList;
    }

    /**
     * Nastavý všechny položky u daného účtu jako otevřené
     * @param billId
     * @return
     */
    public List<StavPolozkyEntity> setAllOpened(Integer billId) {
        return setAllOrdersWithSomeBillAs(billId, StavEnum.otevreny);
    }

    /**
     * Nastaví všechny položky u daného účtu jako připravené
     * @param billId
     * @return
     */
    public List<StavPolozkyEntity> setAllReady(Integer billId) {
        return setAllOrdersWithSomeBillAs(billId, StavEnum.pripraveny);
    }

    /**
     * Nastaví všechny položky u daného účtu jako zavřené
     * @param billId
     * @return
     */
    public List<StavPolozkyEntity> setAllClosed(Integer billId) {
        return setAllOrdersWithSomeBillAs(billId, StavEnum.zavreny);
    }
}
