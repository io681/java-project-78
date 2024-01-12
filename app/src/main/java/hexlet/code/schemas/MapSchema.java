package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema {
    static final MapSchema MAP_SCHEMA = new MapSchema();
    Map<?, ?> mapForValidation = new HashMap<>();
    int sizeForValid;
    private MapSchema() {
    }
    public static MapSchema getMapSchema() {
        return MAP_SCHEMA;
    }

    public boolean isValid(Object obj) {
        if (!(obj instanceof Map<?, ?>) && !(obj == null)) {
            return false;
        }
        setMapForValidation((Map<?, ?>) obj);

        if (isRequired() && obj == null) {
            return false;
        }
        if (getSizeForValid() > 0 && !(getMapForValidation().size() == getSizeForValid())) {
            return false;
        }
        return true;
    }

    public Map<?, ?> getMapForValidation() {
        return mapForValidation;
    }

    public void setMapForValidation(Map<?, ?> mapForValidation) {
        this.mapForValidation = mapForValidation;
    }
    public MapSchema required() {
        setRequired(true);
        return getMapSchema();
    }
    public MapSchema sizeof(int size) {
        setSizeForValid(size);
        return getMapSchema();
    }

    public void shape(Map<String, BaseSchema> schemas) {
//        desription schema for each key;
    }

    public void clearCash() {
        setRequired(false);
    }

    public int getSizeForValid() {
        return sizeForValid;
    }

    public void setSizeForValid(int sizeForValid) {
        this.sizeForValid = sizeForValid;
    }
}
