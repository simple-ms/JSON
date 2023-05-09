package ms.simple.projects.simplejson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

public class JSON {
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());


    public static void withMapper(ObjectMapper objectMapper) {
        mapper = objectMapper;
    }

    public static JsonNode create(String key, Object value) {
        ObjectNode node = mapper.createObjectNode();

        if (value instanceof String) {
            node.put(key, (String) value);
        } else if (value instanceof Boolean) {
            node.put(key, (Boolean) value);
        } else {
            System.out.println("Put Value Error");
            //TODO ThrowExcemption
        }
        return node;
    }

    public static ObjectNode create(String k1, String v1, String k2, String v2) {
        ObjectNode node = mapper.createObjectNode();
        node.put(k1, v1);
        node.put(k2, v2);
        return node;
    }

    public static ObjectNode create(String k1, String v1, String k2, boolean v2) {
        ObjectNode node = mapper.createObjectNode();
        node.put(k1, v1);
        node.put(k2, v2);
        return node;
    }

    public static JsonNode parse(String jsonString) {
        try {
            return mapper.readTree(jsonString);
        } catch (JsonProcessingException e) {
            return mapper.createObjectNode();
        }
    }

    public static String stringify(Object node) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static String stringify(List<Object> nodes) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nodes);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

}
