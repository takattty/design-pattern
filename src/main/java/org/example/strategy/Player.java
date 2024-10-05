package org.example.strategy;

public class Player {
    private final String name;
    private final Strategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand() {
        // TODO: 大事なのはここで、じゃんけんの戦術は全部Strategyに渡している
        // TODO: で、どんな戦術かはコンストラクタ時に決定している
        return strategy.nextHand();
    }

    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    public void even() {
        gameCount++;
    }

    @Override
    public String toString() {
        return "["
                + name + ":"
                + gameCount + " games, "
                + winCount + " win, "
                + loseCount + " lose"
                + "]";
    }
}
