package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;


public final class MapSchema<K, V> extends BaseSchema {
    int sizeForValid;
    public MapSchema() {
    }
    @Override
    public boolean isValid(Object obj) {
        Map<K, V> actual;
        boolean result = super.isValid(obj);

        try {
            actual = (HashMap<K, V>) obj;
        } catch (ClassCastException exc) {
            return false;
        }

        if (getSizeForValid() > 0 && !(actual.size() == getSizeForValid())) {
            return false;
        }
        return result;
    }
    public boolean checkInstance(Object obj) {
        return obj instanceof Map<?, ?> || obj == null;
    }

    public MapSchema<K, V> sizeof(int size) {
        setSizeForValid(size);
        return this;
    }

//    public void shape(Map<String, BaseSchema> schemas) {
//    }

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
