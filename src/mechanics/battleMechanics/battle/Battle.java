package mechanics.battleMechanics.battle;

import entity.player.Challenger;
import entity.tower_entity.TowerEntity;

public class Battle {
    private final Challenger CHALLENGER;
    private final TowerEntity OPPONENT;

    public Battle(Challenger challenger, TowerEntity opponent) {
        this.CHALLENGER = challenger;
        this.OPPONENT = opponent;
        start();
    }

    public void start(){
        
    }
}
