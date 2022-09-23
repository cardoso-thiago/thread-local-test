package br.com.cardoso.log;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalDynamicLog {

    private static final ThreadLocal<Map<String, Object>> context = ThreadLocal.withInitial(HashMap::new);

    private ThreadLocalDynamicLog(){}

    public static void put(String key, Object value) {
        context.get().put(key, value);
    }

    public static Map<String, Object> get() {
        return context.get();
    }

    public static void destroy() {
        context.remove();
    }
}
