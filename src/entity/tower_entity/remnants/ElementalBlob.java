package entity.tower_entity.remnants;
import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.active_skills.ElementalThrow;

public class ElementalBlob extends Remnant {

    // Implement baseHp and baseAtk for each remnants which is multiplied by level.
    private final static int BASE_HP = 20;
    private final static int BASE_ATK = 7;
    
    public ElementalBlob(int lvl) {
        super((int)(BASE_HP * lvl * 0.17),
        (int)(BASE_HP * lvl * 0.17),
        (int)(BASE_ATK * lvl * 0.19), 
        lvl,
        "Elemental Blob",
        "write description here",
        "write story here",
        new ElementalThrow(),
        null);
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " flungs an Elemental Throw!");
        dmgAttack(opponent, atk);
    }

    @Override
    public void defeated(Battle battle){
        System.out.println();
        System.out.println("| " + getName() + " has been defeated.");
        System.out.println("| The Elemental Blob collapses into a quiet puddle, its shimmer fading into the floor.");
        battle.getChallenger().resetLastDamage();
        battle.getChallenger().gainXp((int)(lvl * (1.00 + Math.random())));
        battle.getChallenger().getCurrentArea().getAreaEntities().remnantDefeated(this);
    }



    
}
