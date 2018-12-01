// Tomáš Vopat - vopattom

package ristaurace.helpObjects;

public enum StavEnum {
    otevreny,
    pripraveny,
    zavreny;

    @Override
    public String toString() {
        return this.name();
    }
}
