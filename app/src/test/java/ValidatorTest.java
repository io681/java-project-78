import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidatorTest {
    private StringSchema schema;

    @BeforeEach
    void init() {
        Validator v = new Validator();
        StringSchema schema = v.string();
    }
    @Test
    void testIsValidNotCalledRequired() {
        assertTrue(schema.isValid(""), "Failed test isValid");
        assertTrue(schema.isValid(null), "Failed test isValid");
    }

    @Test
    void testIsValid() {
        schema.required();
        assertFalse(schema.isValid(""), "Failed test isValid");
        assertFalse(schema.isValid(null), "Failed test isValid");

        assertFalse(schema.isValid(5), "Failed test isValid");
        assertTrue(schema.isValid("what does the fox say"), "Failed test isValid");
        assertTrue(schema.isValid("hexlet"), "Failed test isValid");
    }

    @Test
    void testContains() {
        schema.required();
        boolean result1 = schema.contains("wh").isValid("what does the fox say"); // true
        boolean result2 = schema.contains("what").isValid("what does the fox say"); // true
        boolean result3 = schema.contains("whatthe").isValid("what does the fox say"); // false

        assertTrue(result1, "Failed test contains");
        assertTrue(result2, "Failed test contains");
        assertFalse(result3, "Failed test contains");
    }

    @Test
    void testIsValidAndContains(){
        schema.contains("whatthe").isValid("what does the fox say");
        boolean result = schema.isValid("what does the fox say"); // Здесь уже false, так как добавлена еще одна проверка contains("whatthe")
        assertFalse(result, "Failed test isValid and contains");
    }
}
