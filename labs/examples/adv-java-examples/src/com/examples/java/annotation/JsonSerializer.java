package com.examples.java.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class JsonSerializer {

    public String serialize(Object object) throws JsonSerializeException {

        try {
            Class<?> objectClass = requireNonNull(object).getClass();
            Map<String, String> jsonElements = new HashMap<>();

            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    jsonElements.put(getSerializedKey(field), (String) field.get(object));
                }
            }
            System.out.println(toJsonString(jsonElements));
            return toJsonString(jsonElements);
        } catch (IllegalAccessException e) {
            throw new JsonSerializeException(e.getMessage());
        }
    }

    private String toJsonString(Map<String, String> jsonMap) {
        StringBuilder elementsString = new StringBuilder();
        for(Map.Entry<String, String> entry: jsonMap.entrySet()) {
            elementsString.append("\""  + entry.getKey() + "\":\"" + entry.getValue() + "\",");
        }
        return "{" + elementsString.substring(0, elementsString.length() - 1) + "}";
    }

    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonField.class).value();

        if (annotationValue.isEmpty()) {
            return field.getName();
        }
        else {
            return annotationValue;
        }
    }
}
