package com.example.prettyjson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PrettyJsonTest {

    @Test
    public void testSimpleObject() {
        String input = "{\"a\":1,\"b\":2}";
        String out = PrettyJson.prettyPrint(input);
        assertTrue(out.contains("{"));
        assertTrue(out.contains("a"));
        assertTrue(out.contains("b"));
    }

    @Test
    public void testBrokenJsonMissingCommas() {
        String input = "{ \"a\": 1 \"b\": 2 }";
        String out = PrettyJson.prettyPrint(input);
        assertTrue(out.contains("\n"));
    }

    @Test
    public void testArrayFormatting() {
        String input = "[1,2,3]";
        String out = PrettyJson.prettyPrint(input);
        assertTrue(out.contains("["));
        assertTrue(out.contains("1"));
    }
}
