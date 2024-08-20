package org.example.state;

public interface State {
    void doClock(Contexts context, int hour); // 時刻設定
    void doUse(Contexts context); // 金庫使用
    void doAlarm(Contexts context); // 非常ベル
    void doPhone(Contexts context); // 通常通話
}
