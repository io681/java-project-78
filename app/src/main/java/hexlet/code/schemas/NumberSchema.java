package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    public boolean checkInstance(Object obj) {
        return obj instanceof Integer || obj == null;
    }
    public NumberSchema required() {
        getDataValidSchemas().put("isRequired", obj -> !((obj == null || obj.toString().isEmpty())));
        return this;
    }
    public NumberSchema positive() {
        getDataValidSchemas().put("isPositive", obj -> {
            try {
                return this.convertType(obj) > 0;
            } catch (NullPointerException exc) {
                return this.convertType(obj) == null;
            }
        });
        return this;
    }
    public NumberSchema range(int startNumber, int endNumber) {
        getDataValidSchemas().put("isRange", obj -> this.convertType(obj) >= startNumber
                && this.convertType(obj) <= endNumber);
        return this;
    }
    public Integer convertType(Object obj) {
        try {
            return (Integer) obj;
        } catch (ClassCastException | NullPointerException exc) {
            return null;
        }
    }
}
