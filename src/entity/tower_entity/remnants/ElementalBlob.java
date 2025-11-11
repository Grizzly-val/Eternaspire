package entity.tower_entity.remnants;
import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.active_skills.tower_entity.ElementalThrow;

public class ElementalBlob extends Remnant {

    // Implement baseHp and baseAtk for each remnants which is multiplied by level.
    private final static int BASE_HP = 20;
    private final static int BASE_ATK = 7;
    
    public ElementalBlob(int lvl) {
        super((int)(BASE_HP * Math.pow(1.00 + 0.17, lvl - 1)),
        (int)(BASE_HP * Math.pow(1.00 + 0.17, lvl - 1)),
        (int)(BASE_ATK * Math.pow(1.00 + 0.14, lvl - 1)), 
        lvl,
        "Elemental Blob",
        "write description here",
        "The Elemental Blob collapses into a quiet puddle, its shimmer fading into the floor.",
        new ElementalThrow(),
        null);
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " flungs an Elemental Throw!");
        dmgAttack(opponent, atk);
    }

    
}
