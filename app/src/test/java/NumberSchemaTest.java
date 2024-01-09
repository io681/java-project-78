import hexlet.code.StringSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    private NumberSchema schema;

    @BeforeEach
    void init() {
        Validator v = new Validator();
        schema = v.number();
    }

    @Test
    void testSimplyIsValid() {
        boolean result1 = schema.isValid(null);
        boolean result2 = schema.positive().isValid(null);
        boolean result3 = schema.isValid("5");
        boolean result4 = schema.isValid(10);
        assertTrue(result1, "Failed test");
        assertTrue(result2, "Failed test");
        assertFalse(result3, "Failed test");
        assertTrue(result4, "Failed test");
    }

    @Test
    void testRequired() {
        schema.required();
        boolean result1 = schema.isValid(null);
        boolean result2 = schema.positive().isValid("5");
        boolean result3 = schema.positive().isValid(10);
        assertFalse(result1, "Failed test");
        assertFalse(result2, "Failed test");
        assertTrue(result3, "Failed test");
    }

    @Test
    void testPositive() {
        boolean result1 = schema.positive().isValid(0);
        boolean result2 = schema.positive().isValid(10);
        boolean result3 = schema.positive().isValid(-1);
        boolean result4 = schema.positive().isValid("87");
        assertFalse(result1, "Failed test");
        assertTrue(result2, "Failed test");
        assertFalse(result3, "Failed test");
        assertFalse(result4, "Failed test");
    }

    @Test
    void testRange() {
        boolean result1 = schema.range(5, 10).isValid(5);
        boolean result2 = schema.range(5, 10).isValid(10);
        boolean result3 = schema.range(5, 10).isValid(4);
        boolean result4 = schema.range(5, 10).isValid(11);
        assertTrue(result1, "Failed test");
        assertTrue(result2, "Failed test");
        assertFalse(result3, "Failed test");
        assertFalse(result4, "Failed test");
    }

    @Test
    void testAllValidation() {
        boolean result1 = schema.positive().range(-5, 5).isValid(5);
        boolean result2 = schema.positive().range(-5, 5).isValid(6);
        boolean result3 = schema.positive().range(-5, 5).isValid(-4);
        boolean result4 = schema.positive().range(-5, 5).isValid(0);
        assertTrue(result1, "Failed test");
        assertFalse(result2, "Failed test");
        assertFalse(result3, "Failed test");
        assertFalse(result4, "Failed test");
    }
}
