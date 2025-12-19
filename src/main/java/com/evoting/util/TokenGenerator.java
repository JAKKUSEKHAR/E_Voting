package com.evoting.util;
public class TokenGenerator {
    public static String generateToken() {
        return "VT" + (int)(Math.random() * 1000000);
    }
}
