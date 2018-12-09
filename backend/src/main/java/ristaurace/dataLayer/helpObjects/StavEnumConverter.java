// Tomáš Vopat - vopattom

package ristaurace.dataLayer.helpObjects;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StavEnumConverter implements AttributeConverter<StavEnum, String> {
    @Override
    public String convertToDatabaseColumn(StavEnum stavEnum) {
        return stavEnum.name();
    }

    @Override
    public StavEnum convertToEntityAttribute(String s) {
        return StavEnum.valueOf(s);
    }
}
