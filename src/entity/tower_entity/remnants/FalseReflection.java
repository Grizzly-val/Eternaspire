package entity.tower_entity.remnants;
import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.tower_entity.passive_skills.Mimic;

public class FalseReflection extends Remnant {
    
    private final static int BASE_HP = 25;
    private final static int BASE_ATK = 25;
    
    public FalseReflection(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "False Reflection",
        "Appears as a shadowy, slightly distorted duplicate of the challenger, but with unnaturally long limbs or too many eyes.",
        "The False Reflection shudders, unable to reconcile your true form with its borrowed shadow. It snaps like thin glass, and the distorted image of yourself is banished. Your true self stands alone.",
        null,
        new Mimic());
        
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| The False Reflection lashes out with eerie mimicry.");
        dmgAttack(opponent, atk);
    }
}