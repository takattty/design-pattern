package org.example.state;

public enum StateUtil {
    // 状態遷移用の処理を作るとなると、状態を知らないといけないことに気が付いた
    // それって状態クラスと何が違うのか
    // 自分の状態については知ってるけど、他の状態クラスを知らずに済むがメリットだろうな
    // ただenumで持つ必要はあるんだろうか
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
