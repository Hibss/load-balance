package com.syz.load.balance.rule;

public class TestRandom {

    public static void main(String[] args) {
        int size = 10;
        for (int i = 0; i < 20; i++) {
            double random = Math.random();
            System.out.println(random);
            System.out.println((int) (random *size));
        }
    }
}
