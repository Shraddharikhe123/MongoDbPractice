package com.perennialsys.snapshot.enums;

import java.util.ArrayList;
import java.util.List;

/*
 * This enum gets all pojo class for dynamic implementation in controller
 * */

public class ClassMappingEnum extends PropertiesDynaEnum {
    static {
        System.out.println("Class Loaaded");
        init(ClassMappingEnum.class);
    }

    Class classValue;
    String tableName;

    protected ClassMappingEnum(String name, int ordinal, Class classValue, String tableName) {
        super(name, ordinal);
        this.classValue = classValue;
        this.tableName = tableName;
    }


    public static List<String> getAllKey() {
        ClassMappingEnum[] classMappingEnums = ClassMappingEnum.values();
        List<String> allClassKeyValue = new ArrayList<>();
        for (ClassMappingEnum classMappingEnum : classMappingEnums) {
            allClassKeyValue.add(classMappingEnum.getClassValue().getSimpleName());

        }
        return allClassKeyValue;
    }

    public static String getKeyByValue(String value) {
        ClassMappingEnum[] classMappingEnums = ClassMappingEnum.values();
        for (ClassMappingEnum classMappingEnum : classMappingEnums) {
            String name = classMappingEnum.getClassValue().getSimpleName();
            if (name.equals(value)) {
                return classMappingEnum.toString();
            }
        }
        return null;
    }

    public static Class findClassByKey(String key) {
        ClassMappingEnum[] classMappingEnums = ClassMappingEnum.values();
        Class result = null;
        for (ClassMappingEnum classMappingEnum : classMappingEnums) {
            if (classMappingEnum.name().equals(key)) {
                result = classMappingEnum.getClassValue();
            }

        }
        return result;
    }

    public static List<Class> findAllClassValue() {
        ClassMappingEnum[] classMappingEnums = ClassMappingEnum.values();
        List<Class> className = new ArrayList<>();
        for (ClassMappingEnum classMappingEnum : classMappingEnums) {
            className.add(classMappingEnum.getClassValue());
        }
        return className;
    }

    public static ClassMappingEnum findMasterClassByValue(String key) {
        ClassMappingEnum[] classMappings = ClassMappingEnum.values();
        ClassMappingEnum result = null;
        for (ClassMappingEnum classMapping : classMappings) {
            if (classMapping.getClassValue().getSimpleName().equals(key)) {
                result = classMapping;
            }
        }
        return result;
    }
    public static ClassMappingEnum[] values() {
        return values(ClassMappingEnum.class);
    }

    public Class getClassValue() {
        return classValue;
    }

    public String getTableName() {
        return tableName;
    }


}
