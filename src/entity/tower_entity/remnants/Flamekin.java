package entity.tower_entity.remnants;
import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.active_skills.tower_entity.Implosion;

public class Flamekin extends Remnant {

    
    private final static int BASE_HP = 25;
    private final static int BASE_ATK = 9;
    
    public Flamekin(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Flamekin",
        "Small, fiery clockwork imps, forged from iron and brimstone, that detonate on contact, scarring the floor with molten runes.",
        "The fiery construct sputters and collapses, its molten core cooling into cold, cracked iron",
        new Implosion(),
        null);
        
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| The Flamekin delivers a Flicker Strike.");
        dmgAttack(opponent, atk);
    }

    
}