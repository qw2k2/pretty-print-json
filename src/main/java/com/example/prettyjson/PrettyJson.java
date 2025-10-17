package com.example.prettyjson;

import java.util.ArrayDeque;
import java.util.Deque;

public final class PrettyJson {

    private PrettyJson() {}

    public static String prettyPrint(String input) {
        return prettyPrint(input, 2);
    }

    public static String prettyPrint(String input, int indentSize) {
        if (input == null) return null;

        StringBuilder result = new StringBuilder();
        StringBuilder currentIndent = new StringBuilder();

        boolean inString = false;
        boolean escape = false;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (inString) {
                result.append(c);
                if (escape) {
                    escape = false;
                } else if (c == '\\') {
                    escape = true;
                } else if (c == '"') {
                    inString = false;
                }
                continue;
            }

            if (c == '"') {
                inString = true;
                result.append(c);
                continue;
            }

            if (Character.isWhitespace(c)) {
                if (result.length() > 0 && result.charAt(result.length() - 1) == ':') {
                    result.append(' ');
                }
                continue;
            }

            switch (c) {
                case '{':
                case '[':
                    result.append(c);
                    result.append('\n');
                    stack.push(c);
                    currentIndent.append(" ".repeat(indentSize));
                    result.append(currentIndent);
                    break;

                case '}':
                case ']':
                    if (!stack.isEmpty()) stack.pop();
                    result.append('\n');
                    if (currentIndent.length() >= indentSize) {
                        currentIndent.setLength(currentIndent.length() - indentSize);
                    } else {
                        currentIndent.setLength(0);
                    }
                    result.append(currentIndent);
                    result.append(c);
                    break;

                case ',':
                    result.append(c);
                    result.append('\n');
                    result.append(currentIndent);
                    break;

                case ':':
                    result.append(c);
                    result.append(' ');
                    break;

                default:
                    result.append(c);
            }
        }

        return result.toString();
    }
}
