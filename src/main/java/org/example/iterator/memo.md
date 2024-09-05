# Iteratorパターンの例 - `class ArrayList<E>`
- module: java.base
- package: java.util

## メモ
`ArrayList<E>`クラスが直接`Iterable<E>`を実装しているわけではなく、`ArrayList→AbstractList→List→SequencedCollection→Collection`が継承している。

```java
// ここがIterableを実装
public class ArrayList<E> extends AbstractList<E> implements List<E> {

    public Iterator<E> iterator() {
        return new Itr();
    }

    // ここでIteratorを内部クラスで実装。ArrayListから処理を切り離してる。
    private class Itr implements Iterator<E> {
        Itr() {}
        public boolean hasNext() {}
        public E next() {}
        public void remove() {}

        @Override
        public void forEachRemaining(Consumer<? super E> action) {}
        }
}
```


### 構造理解
自分の理解
1. どういう状況か
   1. 複数のコレクションクラスに対する共通の操作を行いたい場合
2. どういう問題か
   1. 各クラスの実装がバラバラだと、共通のメソッド呼び出しが出来ない
3. どういう解決策か
   1. IteratorIFやIterableIFで共通の操作を定義し、具体的な実装は各クラスに任せる

↓

claude.aiの説明
1. どういう状況か
    - 異なる種類のコレクションクラス（リスト、セット、マップなど）に対して、同じ方法で反復処理を行いたい場合
    - コレクションクラスの実装の詳細を隠蔽し、統一的な方法で要素にアクセスしたい場合

2. どういう問題か
    - 各コレクションクラスの実装が異なるため、共通の反復処理を行うためのインターフェースがない
    - コレクションクラスごとに異なる反復処理のコードを書く必要があり、コードの重複や保守性の低下につながる

3. どういう解決策か
    - `Iterator`インターフェースを定義し、各コレクションクラスがこのインターフェースを実装する
    - `Iterator`インターフェースには、`hasNext()`、`next()`、`remove()`などの共通のメソッドを定義する
    - 各コレクションクラスは、自身の実装に合わせて`Iterator`インターフェースを実装する
    - `Iterable`インターフェースを定義し、`iterator()`メソッドを持つことで、拡張for文（for-each文）での反復処理を可能にする

↓\
↓

再解釈
1. どういう状況か
   - 異なる種類だが抽象化すると同じ型に対して、同じ方法で一つずつ取り出す処理を行いたい場合
     - 違う構造に対して、同じ操作を行いたい場合？
     - 具体的にどういう実装かは見せずに、同じ命令で要素を取り出したい場合
2. どういう問題か
   - 違う種類の構造なので、共通の一つずつ取り出すという操作を呼び出す窓口が無い
     - それぞれ別の方法で一つずつ取り出すコードを書く必要が出る
3. どういう解決策か
   - IFを定義し、それぞれが実装を行う。外部への窓口は共通だが、詳細な実装はそれぞれに合わせる
     - またそれぞれが詳細な実装をしているわけではなく、別のクラスで実装を行う


### t-wadaさんコメント
Iteratorパターンは、「背後の構造を意識させずに、一つずつ取り出すというレベルの抽象化」である