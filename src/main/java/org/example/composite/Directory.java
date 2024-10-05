package org.example.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private final String name;
    private final List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return directory.stream().mapToInt(Entry::getSize).sum();
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    // ディレクトリもファイルも入れられるのがポイント
    // いちいちFile fileやDirectory dirとかしない。
    // Entryで抽象化してるので、これで扱える。
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
