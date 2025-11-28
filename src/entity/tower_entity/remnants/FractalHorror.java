package entity.tower_entity.remnants;
import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.active_skills.InfiniteDetail;

public class FractalHorror extends Remnant {
    
    private final static int BASE_HP = 11;
    private final static int BASE_ATK = 20;
    
    public FractalHorror(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Fractal Horror",
        "A constantly shifting, geometric shape. When you focus on it, its complexity increases, hurting your mind.",
        "The Fractal Horror collapses inward, its infinite detail reduced to a single, meaningless point.",
        new InfiniteDetail(),
        null);
        
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| You are confused by what you are seeing.");
        dmgAttack(opponent, atk);
    }
}
    