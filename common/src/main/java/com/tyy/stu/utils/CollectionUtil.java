package com.tyy.stu.utils;

import java.util.Collection;
import java.util.Map;

public class CollectionUtil {


    private CollectionUtil() {
    }


    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }


    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }


    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }


}
