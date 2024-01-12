package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

import static hexlet.code.schemas.StringSchema.getStringSchema;
import static hexlet.code.schemas.NumberSchema.getNumberSchema;
import static hexlet.code.schemas.MapSchema.getMapSchema;


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
