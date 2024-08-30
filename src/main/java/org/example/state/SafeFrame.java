package org.example.state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Contexts {
    private final TextField textClock = new TextField(60);        // 現在時刻表示
    private final TextArea textScreen = new TextArea(10, 60);     // 警備センター出力
    private final Button buttonUse = new Button("金庫使用");      // 金庫使用ボタン
    private final Button buttonAlarm = new Button("非常ベル");    // 非常ベルボタン
    private final Button buttonPhone = new Button("通常通話");    // 通常通話ボタン
    private final Button buttonExit = new Button("終了");         // 終了ボタン

    // ここの状態をどこで変更させるかも大事そう。
    // 状態管理してるオブジェクトに渡すか、こっちでそのままやるか
    // このままだとあまりStrategyと変わらないと思うので、ここも修正したい
    // 逆に普通のWebアプリだとどう生かせるか考えた方がいいな
    // APIから呼び出すServiceの中の処理なのか、バッチ処理なのか、インポート処理なのかとか
    private State state = StateUtil.DAY.getCode();// 現在の状態

    // コンストラクタ
    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClockを配置
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // textScreenを配置
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // パネルにボタンを格納
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // そのパネルを配置
        add(panel, BorderLayout.SOUTH);
        // 表示
        pack();
        setVisible(true);
        // リスナーの設定
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    // ボタンが押されたらここに来る
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == buttonUse) {           // 金庫使用ボタン
            state.doUse(this);
        } else if (e.getSource() == buttonAlarm) {  // 非常ベルボタン
            state.doAlarm( this);
        } else if (e.getSource() == buttonPhone) {  // 通常通話ボタン
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) {   // 終了ボタン
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }

    // 時刻の設定
    @Override
    public void setClock(int hour) {
        String clockstring = String.format("現在時刻は%02d:00", hour);
        System.out.println(clockstring);
        textClock.setText(clockstring);

        // TODO: ここが大事。stateは既に状態を持っている。
        // TODO: その状態を持つstateに時刻の設定を委譲しているので、「時刻の設定」=「現在の状態に依存した処理」が成立。
        // TODO: State IFの処理は全て、現在の状態に依存した処理となる（=状態によって振る舞いが異なる処理）
        // TODO: 理由はState IFの実装が「状態を持つクラス」で、その実装クラスで各自処理を行っているので、状態によって振る舞いが異なるという訳。
        state.doClock(this, hour);
    }

    // 状態変化
    @Override
    public void changeState(State state) {
        System.out.println(this.state + "から" + state + "へ状態が変化しました。");
         this.state = StateUtil.change(state);
//        this.state = state;
    }

    // 警備センター警備員呼び出し
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    // 警備センター記録
    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }

}
