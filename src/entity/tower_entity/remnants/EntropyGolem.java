package entity.tower_entity.remnants;
import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.passive_skills.WovenDecay;

public class EntropyGolem extends Remnant {
    
    private final static int BASE_HP = 70;
    private final static int BASE_ATK = 5;
    
    public EntropyGolem(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Entropy Golem",
        "A lumbering figure made of rapidly aging matter. Parts of its body turn to dust, then briefly re-solidify into younger, denser material before degrading again.",
        "The Entropy Golem ceases its frantic cycle of decay and regeneration. Its mass violently accelerates to a billion years of age in a single instant, dissolving into a cloud of primordial dust. The end cannot be reversed.",
        null,
        new WovenDecay());
        
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| The Entropy Golem slams into you with decaying force.");
        dmgAttack(opponent, atk);
    }
}