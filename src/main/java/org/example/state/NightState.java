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
