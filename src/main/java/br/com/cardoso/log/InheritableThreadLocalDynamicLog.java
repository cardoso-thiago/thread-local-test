package br.com.cardoso.log;

import java.util.HashMap;
import java.util.Map;

public class InheritableThreadLocalDynamicLog {

    private static final InheritableThreadLocal<Map<String, Object>> context = new InheritableThreadLocal<>() {
        @Override
        protected Map<String, Object> childValue(Map<String, Object> parentValue) {
            if (parentValue == null) {
                return null;
            }
            return new HashMap<>(parentValue);
        }
    };

    private InheritableThreadLocalDynamicLog(){}

    public static void put(String key, Object value) {
        Map<String, Object> stringObjectMap = context.get();
        if(stringObjectMap == null) {
            context.set(new HashMap<>(Map.of()));
        }
        context.get().put(key, value);
    }

    public static Map<String, Object> get() {
        return context.get();
    }

    public static void destroy() {
        context.remove();
    }
}
