package org.example.state;

public enum StateUtil {
    DAY(DayState.getInstance()),
    NIGHT(NightState.getInstance());

    private final State code;

    StateUtil(State code) {
        this.code = code;
    }

    // TODO: ここの状態遷移を別のデータ構造で持って、.changeStateとかで上手く遷移させたい。
    public static State change(State state) {
        if (state == DAY.code) {
            return NIGHT.code;
        } else {
            return DAY.code;
        }
    }
}
