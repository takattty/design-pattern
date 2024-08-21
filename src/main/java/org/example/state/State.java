package org.example.state;

public interface State {
    // TODO: ここで定義されているメソッドは全て、「状態によって振る舞いが異なる処理」であることを認識することが大事。
    // TODO: 状態を表すクラスでこのメソッド達を実装するので。
    void doClock(Contexts context, int hour); // 時刻設定
    void doUse(Contexts context); // 金庫使用
    void doAlarm(Contexts context); // 非常ベル
    void doPhone(Contexts context); // 通常通話
}
