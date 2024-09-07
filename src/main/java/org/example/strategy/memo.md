# Strategyパターンの例 - `Comparator<T>`
- module: java.base
- package: java.util

## メモ
```java
public interface Comparator<T> {
    int compare(T o1, T o2); 
}

public class Arrays {
    public static <T> void sort(T[] a, Comparator<? super T> c) {}
}

class HogeComparator implements Comparator<T> {
    @Override
    public int compare(Hoge h1, Hoge h2) {} 
}

// ここで比較方法を変えている（いわゆる戦術部分）
// オブジェクトの状態はどうでもいいので、Strategyパターンとなるイメージ
// Arrays.sort(hoge, HogeComparator);
```