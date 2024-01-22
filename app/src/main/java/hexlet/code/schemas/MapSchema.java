package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema<K, V> extends BaseSchema {
    public boolean checkInstance(Object obj) {
        return obj instanceof Map<?, ?> || obj == null;
    }
    public MapSchema<K, V> required() {
        dataValidSchemas.put("isRequired", obj -> !((obj == null || obj.toString().isEmpty())));
        return this;
    }
    public boolean isValid(Object obj, BaseSchema schema) {
        return schema.isValid(obj);
    }
    public MapSchema<K, V> sizeof(int size) {
        dataValidSchemas.put("sizeOfValid", obj -> (size > 0 && convertType(obj).size() == size));
        return this;
    }
    public void shape(Map<String, BaseSchema> schemasForValidation) {
        dataValidSchemas.put("isShape", obj -> {
            for (var entry : convertType(obj).entrySet()) {
                if (schemasForValidation.containsKey(entry.getKey())
                        && !this.isValid(entry.getValue(), schemasForValidation.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        });
    }
    public HashMap<K, V> convertType(Object obj) {
        try {
            return (HashMap<K, V>) obj;
        } catch (ClassCastException exc) {
            return null;
        }
    }
}
