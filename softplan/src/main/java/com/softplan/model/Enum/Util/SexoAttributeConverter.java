package com.softplan.model.Enum.Util;

import com.softplan.model.Enum.SexoEnum;
import javax.persistence.AttributeConverter;


import static com.softplan.model.Enum.SexoEnum.FEMININO;
import static com.softplan.model.Enum.SexoEnum.MASCULINO;

public class SexoAttributeConverter implements AttributeConverter<SexoEnum, String> {

    @Override
    public String convertToDatabaseColumn(SexoEnum attribute) {
        if (attribute == null)
            return null;

        switch (attribute) {
            case FEMININO:
                return "Feminino";

            case MASCULINO:
                return "Masculino";

            default:
                throw new IllegalArgumentException(attribute + " not supported.");
        }
    }

    @Override
    public SexoEnum convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        switch (dbData) {
            case "Feminino":
                return FEMININO;

            case "Masculino":
                return MASCULINO;

            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }
}