package entity.tower_entity.remnants;
import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.active_skills.tower_entity.ElementalBurst;

public class ElementalBlob extends Remnant {

    // Implement baseHp and baseAtk for each remnants which is multiplied by level.
    private final static int BASE_HP = 20;
    private final static int BASE_ATK = 7;
    
    public ElementalBlob(int lvl) {
        super((int)(BASE_HP + (int)(lvl * lvl * 0.5734)), 
        (int)(BASE_HP + (int)(lvl * lvl * 0.5734)), 
        (int)((BASE_ATK + (int)(lvl * lvl * 0.4725))), 
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
