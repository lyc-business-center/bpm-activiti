package com.star.springboot.bmp.activiti.util;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import static java.time.temporal.ChronoField.*;

public class Utils {

    public static final String DATA_FORMAT_DATA_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATA_FORMAT_DATA = "yyyy-MM-dd";
    public static final String DATA_FORMAT_TIME = "HH:mm:ss";

    /** 从map中取值 **/
    public static String safeString(Map map , String key){
        return safeString(map, key, null);
    }

    public static String safeString(Map map , String key, String defaultValue){
        if(map != null && map.getOrDefault(key, null) != null){
            return map.get(key).toString();
        }
        return defaultValue;
    }

    public static Long safeLong(Map map, String key){
        return safeLong(map, key, null);
    }

    public static Long safeLong(Map map, String key, Long defaultValue){
        String str ;
        if((str = safeString(map, key)) != null){
            return Long.valueOf(str);
        }
        return defaultValue;
    }

    public static Integer safeInteger(Map map, String key, Integer defaultValue){
        String str;
        if((str = safeString(map, key)) != null){
            return Integer.valueOf(str);
        }
        return defaultValue;
    }
    public static Integer safeInteger(Map map, String key){
        return safeInteger(map, key, null);
    }


    /** 集合处理 **/

    public static boolean isEmpty(Collection collection){
        return collection == null || collection.size() == 0;
    }


    public static <T> T[] appendArray(T[] array, T t){
        T[] tarray = (T[])Array.newInstance(t.getClass(), array == null ? 1 : array.length + 1);
        tarray[tarray.length-1] = t;
        if(array == null) return tarray;
        System.arraycopy(array, 0, tarray, 0, array.length);
        return tarray;
    }

    /** 时间处理 **/

    public static String date2str(Date date, String format){
        return DateTimeFormatter.ofPattern(format).
                format(date.toInstant().atZone(ZoneId.systemDefault()));
    }

    public static String date2str(Date date){
        return date2str(date, DATA_FORMAT_DATA_TIME);
    }

    public static Date str2date(String str, String format){
        return Date.from((Instant.from(
                DateTimeFormatter.ofPattern(format)
                        .withZone(ZoneId.systemDefault()).parse(str))));
    }

    public static Date str2date(String str){
        return str2date(str, DATA_FORMAT_DATA_TIME);
    }

    public static Date dayBegin(Date date){
        return Date.from(date.toInstant().atZone(ZoneId.systemDefault())
                .with(HOUR_OF_DAY, HOUR_OF_DAY.range().getMinimum())
                .with(MINUTE_OF_DAY, MINUTE_OF_DAY.range().getMinimum())
                .with(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMinimum())
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMinimum()).toInstant());

    }

    public static Date dayEnd(Date date){
        return Date.from(date.toInstant().atZone(ZoneId.systemDefault())
                .with(HOUR_OF_DAY, HOUR_OF_DAY.range().getMaximum())
                .with(MINUTE_OF_HOUR, MINUTE_OF_HOUR.range().getMaximum())
                .with(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMaximum())
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMaximum()).toInstant());
    }

    /** 精度处理 **/
    public static Double scale(Double value, int scale){
        return scale(value, scale, RoundingMode.HALF_UP);
    }

    public static Double scale(Double value, int scale, RoundingMode roundingMode){
        return BigDecimal.valueOf(value).setScale(scale, roundingMode).doubleValue();
    }


    /** 转换数据类型 **/
    public static <T, V> V[] parseArrayType(T[] source,Function<T, V> fun, Class<V> vCls ){
        if(source == null) return null;
        V[] newArray = (V[])Array.newInstance(vCls, source.length);
        for( int i = 0 ; i < source.length ; i++){
            newArray[i] = fun.apply(source[i]);
        }
        return newArray;
    }


}
