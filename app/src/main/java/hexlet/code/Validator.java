package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {
    public static final String STRING_SCHEMA = "StringSchema";
    public static final String NUMBER_SCHEMA= "NumberSchema";
    public static final String MAP_SCHEMA= "MapSchema";
    BaseSchema schema;
    public StringSchema string() {
        return (StringSchema) getSchema("StringSchema");
    }
    public NumberSchema number() {
        return (NumberSchema) getSchema("NumberSchema");
    }
    public MapSchema map() {
        return (MapSchema) getSchema("MapSchema");
    }

    public BaseSchema getSchema(String name) {
        if (name.equals(STRING_SCHEMA)) {
            return new StringSchema();
        } else if (name.equals(NUMBER_SCHEMA)) {
            return new NumberSchema();
        } else if (name.equals(MAP_SCHEMA)) {
            return new MapSchema();
        }
        return null;
    }
}
