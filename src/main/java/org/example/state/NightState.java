package org.example.state;

public class NightState implements State {
    private static final NightState singleton = new NightState();
    
    private NightState() {}
    
    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Contexts contexts, int hour) {
        if (9 <= hour || hour < 7) {
            // ここでDayStateのことを知らないといけないので、クラス間の依存関係が深まる
            // TODO: 状態遷移専用のeunumを作ればいいのでは?自分のインスタンスを渡せば、NightStateから状態遷移できるやつだけに絞れるので。
            // TODO: 簡単な状態遷移用のenumを作成する
            contexts.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Contexts contexts) {
        contexts.recordLog("金庫使用（夜間）");
    }

    @Override
    public void doAlarm(Contexts contexts) {
        contexts.callSecurityCenter("非常ベル（夜間）");
    }

    @Override
    public void doPhone(Contexts contexts) {
        contexts.callSecurityCenter("通常の通話（夜間）");
    }

    @Override
    public String toString() {
        return "[夜間]";
    }
}
