package org.example.strategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // ここで「戦術」を渡しているイメージ（小さくなるような処理）
        list.sort(String::compareTo);
//        list.sort((x, y) -> x.compareTo(y));
        System.out.println("小さい順：　" + list);

        // ここで「戦術」を渡しているイメージ（大きくなるような処理）
        list.sort(Comparator.reverseOrder());
//        list.sort((x, y) -> y.compareTo(x));
        System.out.println("大きい順：　" + list);
    }
}
