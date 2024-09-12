package org.example.proxy;

public class PrinterProxy implements  Printable {
    private String name;
    private Printer real;

    public PrinterProxy() {
        this.name = "No Name";
        this.real = null;
    }

    public PrinterProxy(String name) {
        this.name = name;
        this.real = null;
    }

    @Override
    public void setPrinterName(String name) {
        // 代理で行っていたインスタンス化前の処理だが、既にインスタンス化が行われていればそっちを使うみたいなイメージ
        if (real != null) {
            real.setPrinterName(name);
        }

        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        // ここでPrinterクラスの生成とメソッド実行を行っている
        // 継承っぽいけど、違うのかな？移譲になってる？
        realize();
        real.print(string);
    }

    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
