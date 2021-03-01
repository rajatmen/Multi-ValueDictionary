package test;

import com.company.MultiValueDict;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiValueDictTest {
    private MultiValueDict<String, String> dictionary;

    @BeforeEach
    public void setUp() throws Exception {
        dictionary = new MultiValueDict<>();
    }

    @Test
    @DisplayName("Test Add Function - Happy Path")
    public void addHappy() throws Exception {
        dictionary.add("foo" , "bar");
        assertTrue(dictionary.valueExists("foo", "bar"));
    }

    @Test
    @DisplayName("Test Add Function - Error: Value Already Exists")
    public void addError() throws Exception {
        dictionary.add("foo", "bar");
        assertThrows(Exception.class, () -> dictionary.add("foo", "bar"));
    }

    @Test
    @DisplayName("Remove - Success")
    public void removeSucess() throws Exception {
        dictionary.add("foo", "bar");
        assertTrue(dictionary.remove("foo", "bar"));
    }

    @Test
    @DisplayName("Remove - Success")
    public void removeError() throws Exception {
        assertThrows(Exception.class, () -> dictionary.remove("foo", "bar"));
    }

    @Test
    @DisplayName("Remove All - Success")
    public void removeAllSuccess() throws Exception {
        dictionary.add("foo", "bar");
        dictionary.add("foo", "bang");
        assertTrue(dictionary.removeAll("foo"));
        assertEquals(0, dictionary.getKeys().size());
    }

    @Test
    @DisplayName("Remove All - Error")
    public void removeAllError() throws Exception {
        assertThrows(Exception.class, () -> dictionary.removeAll("foo"));
    }

    @Test
    @DisplayName("Test Value Exists Function - Happy Path")
    public void valueExists() throws Exception {
        assertFalse(dictionary.valueExists("foo", "bar"));
        dictionary.add("foo" , "bar");
        assertTrue(dictionary.valueExists("foo", "bar"));
    }

    @Test
    @DisplayName("Test get all  members - Success")
    public void getAllMembers() throws Exception {
        dictionary.add("foo", "bar");
        dictionary.add("bang", "bar");
        assertEquals(2, dictionary.getAllMembers().size());
        assertEquals("bar", dictionary.getAllMembers().get(0));
        assertEquals("bar", dictionary.getAllMembers().get(1));
    }

    @Test
    @DisplayName("Test get keys")
    public void getKeys() throws Exception {
        dictionary.add("foo", "bar");
        assertEquals(1, dictionary.getKeys().size());
        assertTrue(dictionary.getKeys().contains("foo"));
    }

    @Test
    @DisplayName("Test get members")
    public void getMembers() throws Exception {
        dictionary.add("foo", "bar");
        assertEquals(1, dictionary.getMembers("foo").size());
        assertTrue(dictionary.getMembers("foo").contains("bar"));
    }

    @Test
    @DisplayName("Test clear")
    public void clear() throws Exception {
        dictionary.add("foo", "bar");
        assertTrue(dictionary.getItems().size() > 0);
        dictionary.clear();
        assertEquals(dictionary.getItems().size(), 0);
    }

    @Test
    @DisplayName("Test key exists")
    public void keyExists() throws Exception {
        assertFalse(dictionary.keyExists("foo"));
        dictionary.add("foo", "bar");
        assertTrue(dictionary.keyExists("foo"));
    }

    @Test
    @DisplayName("Test get items")
    public void getItems() throws Exception {
        dictionary.add("foo", "bar");
        assertEquals(1, dictionary.getItems().size());
        assertTrue(dictionary.getItems().get("foo").contains("bar"));
    }

    @Test
    @DisplayName("Test toString empty dictionary")
    public void testToStringEmpty() {
        assertEquals("Empty Dictionary \n", dictionary.toString());
    }

    @Test
    @DisplayName("Test toString with items")
    public void testToStringWithItems() throws Exception {
        dictionary.add("foo", "bar");
        assertEquals("1) foo: bar\n" , dictionary.toString());
    }
}
