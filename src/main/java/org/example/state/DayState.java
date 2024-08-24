package org.example.state;

public class DayState implements State {
    // 次の疑問はここのシングルトンだな。
    // これマルチスレッドだとどうなるんだっけ？グローバル変数？
    // ただし自身のフィールド変数を持たないから、スレッドセーフで大丈夫？
    private static final DayState singleton = new DayState();

    private DayState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Contexts contexts, int hour) {
       if (hour < 9 || 17 <= hour) {
           // ここでNightStateのことを知らないといけないので、クラス間の依存関係が深まる
           // TODO: 状態遷移専用のeunumを作ればいいのでは?自分のインスタンスを渡せば、DayStateから状態遷移できるやつだけに絞れるので。
//           contexts.changeState(NightState.getInstance());
            contexts.changeState(this);
       }
    }

    @Override
    public void doUse(Contexts contexts) {
        contexts.recordLog("金庫使用（昼間）");
    }

    @Override
    public void doAlarm(Contexts contexts) {
        contexts.callSecurityCenter("非常ベル（昼間）");
    }

    @Override
    public void doPhone(Contexts contexts) {
        contexts.callSecurityCenter("通常の通話（昼間）");
    }

    @Override
    public String toString() {
        return "[昼間]";
    }
}
