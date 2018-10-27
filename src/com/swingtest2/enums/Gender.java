package com.swingtest2.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum Gender {

    @XmlEnumValue("MALE")
    MALE,

    @XmlEnumValue("FEMALE")
    FEMALE;

}
