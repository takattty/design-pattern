package org.example.state;

public class DayState implements State {
    private static final DayState singleton = new DayState();

    private DayState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Contexts contexts, int hour) {
       if (hour < 9 || 17 <= hour) {
           contexts.changeState(NightState.getInstance());
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
