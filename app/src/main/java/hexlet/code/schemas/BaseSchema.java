package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Map<String, Predicate> dataValidSchemas = new HashMap<>();
    public BaseSchema() {
        dataValidSchemas.put("isInstance", obj -> checkInstance(obj));
    }
    public final boolean isValid(Object obj) {
        for (var entry : dataValidSchemas.entrySet()) {
            if (!entry.getValue().test(obj)) {
                return  false;
            }
        }
        return true;
    }
    public abstract boolean checkInstance(Object obj);
//    public final Map<String, Predicate> getDataValidSchemas() {
//        return dataValidSchemas;
//    }
}
