import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaWithShapeTest {
//    @BeforeAll
//    void init() {
//        Validator v = new Validator();
//        MapSchema schema = v.map();
//
//        Map<String, BaseSchema> schemas = new HashMap<>();
//        schemas.put("name", v.string().required());
//        schemas.put("age", v.number().positive());
//        schema.shape(schemas);
//    }
//
//    @Test
//    public void shapeTest1() {
//        Map<String, Object> human1 = new HashMap<>();
//        human1.put("name", "Kolya");
//        human1.put("age", 100);
//        boolean result = schema.isValid(human1);
//        assertTrue(result, "Failed test");
//    }
//
//    @Test
//    public void shapeTest2() {
//        Map<String, Object> human2 = new HashMap<>();
//        human2.put("name", "Maya");
//        human2.put("age", null);
//        boolean result = schema.isValid(human2);
//        assertTrue(result, "Failed test");
//    }
//
//    @Test
//    public void shapeTest3() {
//        Map<String, Object> human3 = new HashMap<>();
//        human3.put("name", "");
//        human3.put("age", null);
//        boolean result = schema.isValid(human3);
//        assertFalse(result, "Failed test");
//    }
//
//    @Test
//    public void shapeTest4() {
//        Map<String, Object> human4 = new HashMap<>();
//        human4.put("name", "Valya");
//        human4.put("age", -5);
//        boolean result = schema.isValid(human4);
//        assertFalse(result, "Failed test");
//    }
}
