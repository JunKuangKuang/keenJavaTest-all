package xyz.clzly.keen.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncodeUtilsTest {

    @Test
    public void chineseToCode() {
        System.out.println(EncodeUtils.chineseToCode("嘻嘻"));
    }

    @Test
    public void codeToChinese() {
        System.out.println(EncodeUtils.codeToChinese("\\345\\230\\273\\345\\230\\273"));
    }
}