import hexlet.code.schemas.MapSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class MapSchemaTest {
    private MapSchema schema;

    @BeforeEach
    void init() {
        Validator v = new Validator();
        schema = v.map();
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

    @AfterEach
    void clear() {
        schema.clearCash();
    }
}
