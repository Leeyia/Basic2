package com.racofix.aacmvp.annotation;


import com.racofix.aacmvp.Logic;

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
