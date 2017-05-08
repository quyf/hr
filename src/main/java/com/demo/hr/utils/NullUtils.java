package com.demo.hr.utils;

import java.util.List;
import java.util.Map;

/**
 * 判断对象或列表是否为NULL
 *
 */
public abstract class NullUtils {

    public static boolean isNull(Object obj) {
        if (null == obj) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(List<?> list) {
        if (null == list || list.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        if (null == map || map.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        if (null == str || str.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String[] s) {
        if (null == s || s.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断集合是否空或者存在空元素
     *
     * @param s 字符串集合
     * @return 集合为空，返回true；集合中含有空元素，返回true。
     * @author rainqin
     */
    public static boolean hasEmpty(String... s) {

        if (s != null && s.length > 0) {
            for (String sub : s) {
                if (null == sub || sub.isEmpty() || sub.trim().isEmpty()) {
                    return true;
                }
            }
            return false;
        }

        return true;
    }

    /**
     * 判断集合是否为null或者存在null元素
     *
     * @param arrs 集合
     * @return 集合为null，返回true；集合中含有null元素，返回true。
     * @author rainqin
     */

    public static <T> boolean hasNull(T... arrs) {
        if (arrs != null && arrs.length > 0) {
            for (T t : arrs) {
                if (null == t) {
                    return true;
                }
            }
            return false;
        }

        return true;
    }

    /**
     * null值替换
     *
     * @param obj
     * @param defau
     * @return 如果obj为null，那么返回obj；否则返回默认值defau。
     */
    public static <T> T nvl(T obj, T defau) {
        if (obj == null) {
            return defau;
        }
        return obj;
    }

    /**
     * 判断对象是否为空,异常抛出传入的message
     *
     * @param object
     * @param message
     * @param <T>
     * @return
     */
    public static <T> T checkNotNull(T object, String message) throws Exception {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }

    /**
     * 判断字符串是否为空且不为空串,异常抛出传入的message
     *
     * @param str
     * @param message
     * @return
     */
    public static String checkNotNull(String str, String message) throws Exception {
        if (str == null || str.isEmpty()) {
            throw new NullPointerException(message);
        }
        return str;
    }

    /**
     * 判断List不为空且不为空列表,异常抛出传入的message
     * @param <T>
     *
     * @param list
     * @param message
     * @return
     */
    public static <T> List<T> checkNotNull(List<T> list, String message) throws Exception {
        if (list == null || list.isEmpty()) {
            throw new NullPointerException(message);
        }
        return list;
    }

}
