package hexlet.code;

import static hexlet.code.StringSchema.getStringSchema;
import static hexlet.code.NumberSchema.getNumberSchema;
import static hexlet.code.MapSchema.getMapSchema;


public class Validator {
    public StringSchema string() {
        return getStringSchema();
    }
    public NumberSchema number() {
        return getNumberSchema();
    }
    public MapSchema map() {
        return getMapSchema();
    }
}
