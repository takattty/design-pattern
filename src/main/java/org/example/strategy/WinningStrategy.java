package org.example.strategy;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private final Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        // 前回の勝負に勝ったら同じ手を、負けたらランダムな手を選択する
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
