package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;


public final class MapSchema<K, V> extends BaseSchema {
    private int sizeForValid;
    private Map<String, BaseSchema> schemas = new HashMap<>();
    private boolean isShape;
    public MapSchema() {
    }
    public boolean checkInstance(Object obj) {
        return obj instanceof Map<?, ?> || obj == null;
    }
    public boolean additionalValidate(Object obj) {
        Map<K, V> actual;

        try {
            actual = (HashMap<K, V>) obj;
        } catch (ClassCastException exc) {
            return false;
        }

        if (getSizeForValid() > 0 && !(actual.size() == getSizeForValid())) {
            return false;
        }
        if (isShape) {
            for (var entry : actual.entrySet()) {
                if (getSchemas().containsKey(entry.getKey())
                        && !this.isValid(entry.getValue(), getSchemas().get(entry.getKey()))) {
                    return false;
                }
            }
        }

        return true;
    }

    public MapSchema<K, V> required() {
        setRequired(true);
        return this;
    }
    public boolean isValid(Object obj, BaseSchema schema) {
        return schema.isValid(obj);
    }

    public MapSchema<K, V> sizeof(int size) {
        setSizeForValid(size);
        return this;
    }

    public void shape(Map<String, BaseSchema> schemasForValidation) {
        setShape(true);
        setSchemas(schemasForValidation);
    }

    public void clearCash() {
        setRequired(false);
    }

    public int getSizeForValid() {
        return sizeForValid;
    }

    public void setSizeForValid(int sizeForSetValid) {
        this.sizeForValid = sizeForSetValid;
    }

    public boolean isShape() {
        return isShape;
    }

    public void setShape(boolean shape) {
        isShape = shape;
    }

    public Map<String, BaseSchema> getSchemas() {
        return schemas;
    }

    public void setSchemas(Map<String, BaseSchema> schemasForSet) {
        this.schemas = schemasForSet;
    }
}
