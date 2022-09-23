package br.com.cardoso.log;

import java.util.HashMap;
import java.util.Map;

public class SimpleDynamicLog {

    private static final Map<String, Object> context = new HashMap<>();

    private SimpleDynamicLog(){}

    public static void put(String key, Object value) {
        context.put(key, value);
    }

    public static Map<String, Object> get() {
        return context;
    }

    public static void destroy() {
        context.clear();
    }
}
