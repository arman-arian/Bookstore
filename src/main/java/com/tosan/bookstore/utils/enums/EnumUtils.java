package com.tosan.bookstore.utils.enums;

import java.lang.reflect.Field;
import java.util.*;

public final class EnumUtils {
    public static String GetEnumDescription(Enum<?> e) {
        try {
            Class<?> clazz = e.getClass();
            Field field = clazz.getField(e.toString());
            field.setAccessible(true);
            if (field.isAnnotationPresent(EnumDescription.class)) {
                return field.getAnnotation(EnumDescription.class).value();
            } else {
                return "";
            }
        } catch (Exception ex) {
            return "";
        }
    }

    public static Map<Integer, String> GetEnumDescriptions(Class<?> clazz) {
        Map<Integer, String> enumElementsMap = new HashMap<>();
        try {
            for (Field field : clazz.getFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(EnumDescription.class)) {
                    enumElementsMap.put(
                            ((Enum<?>) field.get(null)).ordinal(),
                            field.getAnnotation(EnumDescription.class).value()
                    );
                }
            }
            return enumElementsMap;
        } catch (Exception ex) {
            return new HashMap<>();
        }
    }

    public static Map<Integer, String> GetEnumNames(Class<?> clazz) {
        Map<Integer, String> enumElementsMap = new HashMap<>();
        try {
            for (Field field : clazz.getFields()) {
                field.setAccessible(true);
                System.out.println(field.getName());
                enumElementsMap.put(
                        ((Enum<?>) field.get(null)).ordinal(),
                        field.getName()
                );
            }
            return enumElementsMap;
        } catch (Exception ex) {
            return new HashMap<>();
        }
    }
}
