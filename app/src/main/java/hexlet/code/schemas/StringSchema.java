package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    public boolean checkInstance(Object obj) {
        return obj instanceof String || obj == null;
    }
    public StringSchema required() {
        getDataValidSchemas().put("isRequired", obj -> !((obj == null || obj.toString().isEmpty())));
        return this;
    }
    public StringSchema minLength(int number) {
        getDataValidSchemas().put("minLength", obj -> (this.convertType(obj).length() >= number));
        return this;
    }

    public StringSchema contains(String stringContains) {
        getDataValidSchemas().put("contains", obj -> this.convertType(obj).contains(stringContains));
        return this;
    }
    public String convertType(Object obj) {
        try {
            return (String) obj;
        } catch (ClassCastException exc) {
            return null;
        }
    }
}
