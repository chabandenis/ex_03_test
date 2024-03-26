package ru.denisch.service;

import ru.denisch.cache.Cache;
import ru.denisch.cache.Mutator;
import ru.denisch.cache.Test;

public class FunctionForTestImpl implements FunctionForTest {
    private int i;
    private int cnt;

    @Override
    @Mutator
    public void setI(int i) {
        System.out.println("Установили значение в исходном классе " + i);
        this.i = i;
    }

    @Override
    @Cache
    @Test
    public String getI() {
        System.out.println("    Исходная версия функции");
        if (cnt >= 0) {
            cnt = 1;
            return String.valueOf(i) + String.valueOf(i);
        } else
            return "";
    }
}