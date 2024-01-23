import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class MapSchemaTest {
    private static MapSchema schema;
    private static Validator v = new Validator();
    private static Map<String, BaseSchema> schemas = new HashMap<>();
    @BeforeEach
    void init() {
        schema = v.map();
    }
    @BeforeAll
    static void setUpShemas() {
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
    }
    @Test
    void testSimplyIsValid() {
        boolean result1 = schema.isValid(null);
        boolean result2  = schema.isValid(new HashMap<>());

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        boolean result3  = schema.isValid(data);

        boolean result4 = schema.isValid(10);

        assertTrue(result1, "Failed test");
        assertTrue(result2, "Failed test");
        assertTrue(result3, "Failed test");
        assertFalse(result4, "Failed test");
    }
    @Test
    void testRequired() {
        schema.required();
        boolean result1 = schema.isValid(null);
        boolean result2  = schema.isValid(new HashMap<>());

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        boolean result3  = schema.isValid(data);

        assertFalse(result1, "Failed test");
        assertTrue(result2, "Failed test");
        assertTrue(result3, "Failed test");
    }
    @Test
    void testSizeof() {
        schema.sizeof(2);
        boolean result1  = schema.isValid(new HashMap<>());

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        boolean result2  = schema.isValid(data);

        Map<String, String> data2 = new HashMap<>();
        data2.put("key1", "value1");
        data2.put("key2", "value2");
        boolean result3 = schema.isValid(data2);

        assertFalse(result1, "Failed test");
        assertFalse(result2, "Failed test");
        assertTrue(result3, "Failed test");
    }

    @Test
    public void shapeTest1() {
        schema.shape(schemas);
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        boolean result = schema.isValid(human1);
        assertTrue(result, "Failed test");
    }
    @Test
    public void shapeTest2() {
        schema.shape(schemas);
        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        boolean result = schema.isValid(human2);
        assertTrue(result, "Failed test");
    }
    @Test
    public void shapeTest3() {
        schema.shape(schemas);
        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        boolean result = schema.isValid(human3);
        assertFalse(result, "Failed test");
    }
    @Test
    public void shapeTest4() {
        schema.shape(schemas);
        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        boolean result = schema.isValid(human4);
        assertFalse(result, "Failed test");
    }
}
