// Tomáš Vopat - vopattom

package ristaurace.dataLayer.helpObjects;

/**
 * Pomocní enum pro mapování databázového enumu "stav"
 */
public enum StavEnum {
    otevreny,
    pripraveny,
    zavreny;

    @Override
    public String toString() {
        return this.name();
    }
}
