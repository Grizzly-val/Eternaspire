package entity.tower_entity.remnants;
import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.active_skills.ElementalBurst;

public class ElementalBlob extends Remnant {

    // Implement baseHp and baseAtk for each remnants which is multiplied by level.
    private final static int BASE_HP = 20;
    private final static int BASE_ATK = 7;
    
    public ElementalBlob(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Elemental Blob",
        "A phyiscal manifestation of elements born from magic",
        "The Elemental Blob collapses into a quiet puddle, its shimmer fading into the floor.",
        new ElementalBurst(),
        null);
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " flungs an Elemental Throw!");
        dmgAttack(opponent, atk);
    }

    
}
