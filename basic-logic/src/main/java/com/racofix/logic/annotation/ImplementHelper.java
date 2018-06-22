package com.racofix.logic.annotation;


import com.racofix.logic.Logic;

public class ImplementHelper {

    public static Logic init(Class<?> clazz) {
        try {
            Implement implement = clazz.getAnnotation(Implement.class);
            if (implement != null)
                return (Logic) implement.value().newInstance();
            return null;
        } catch (InstantiationException e) {
//            throw new RuntimeException("Cannot create an instance of " + clazz, e);
            return null;
        } catch (IllegalAccessException e) {
//            throw new RuntimeException("Cannot create an instance of " + clazz, e);
            return null;
        }
    }
}
