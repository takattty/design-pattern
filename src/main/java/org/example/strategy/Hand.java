package org.example.strategy;

public enum Hand {
    ROCK("グー", 0),
    SCISSORS("チョキ", 1),
    PAPER("パー", 2);

    private final String name;
    private final int handValue;

    private static final Hand[] hands = {
            ROCK, SCISSORS, PAPER
    };

    Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    public static Hand getHand(int handValue) {
        return hands[handValue];
    }

    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    private int fight(Hand h) {
        if (this == h) { // enumはシングルトンなので、オブジェクト比較できる
            return 0;
        } else if (calcHandPower(h)) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * じゃんけんの手の強さの判定.<br>
     * ex) this=グー（0）、h=チョキ（1）<br>
     *     (0 + 1) % 3 → 0あまり1 <br>
     *     あまり1がチョキと同じ値なので、true <br>
     *     つまり、this（グー）の勝ちとなる
     *
     * @param h 相手の手
     * @return thisがhより強い時に、true
     */
    private boolean calcHandPower(Hand h) {
        return ((this.handValue + 1) % 3 == h.handValue);
    }

    @Override
    public String toString() {
        return name;
    }
}
