import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringSchemaTest {
    private StringSchema schema;

    @BeforeEach
    void init() {
        Validator v = new Validator();
        schema = v.string();
    }
    @Test
    void testSimplyIsValid() {
        assertTrue(schema.isValid(""), "Failed test isValid");
        assertTrue(schema.isValid(null), "Failed test isValid");
        assertTrue(schema.isValid("what does the fox say"), "Failed test isValid");
    }

    @Test
    void testRequired() {
        schema.required();
        assertFalse(schema.isValid(""), "Failed test isValid");
        assertFalse(schema.isValid(null), "Failed test isValid");
        assertFalse(schema.isValid(5), "Failed test isValid");
        assertTrue(schema.isValid("what does the fox say"), "Failed test isValid");
    }

    @Test
    void testContains() {
        schema.required();
        boolean result1 = schema.contains("wh").isValid("what does the fox say");
        boolean result2 = schema.contains("what").isValid("what does the fox say");
        boolean result3 = schema.contains("whatthe").isValid("what does the fox say");

        assertTrue(result1, "Failed test contains");
        assertTrue(result2, "Failed test contains");
        assertFalse(result3, "Failed test contains");
    }

    @Test
    void testIsValidAndContains() {
        schema.contains("whatthe").isValid("what does the fox say");
        boolean result = schema.isValid("what does the fox say");
        // Здесь уже false, так как добавлена еще одна проверка contains("whatthe")
        assertFalse(result, "Failed test isValid and contains");
    }

    @Test
    void testMinLength() {
        schema.required();
        schema.minLength(5);
        boolean result1 = schema.isValid("What");
        boolean result2 =  schema.isValid("What ");
        boolean result3 =  schema.isValid("What does");
        assertFalse(result1, "Failed test minLength");
        assertTrue(result2, "Failed test minLength");
        assertTrue(result3, "Failed test minLength");
    }

    @Test
    void testAllValidations() {
        schema.required();
        boolean result1 =  schema.minLength(4).isValid("Wha");
        boolean result2 =  schema.minLength(4).isValid("What does");
        assertFalse(result1, "Failed test AllValidations");
        assertTrue(result2, "Failed test AllValidations");
    }

    @AfterEach
    void clear() {
        schema.clearCash();
    }
}
