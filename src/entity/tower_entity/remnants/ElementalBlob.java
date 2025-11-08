package entity.tower_entity.remnants;
import entity.Entity;
import entity.tower_entity.Remnant;

public class ElementalBlob extends Remnant {

    // Implement baseHp and baseAtk for each remnants which is multiplied by level.
    private final static int BASE_HP = 30;
    private final static int BASE_ATK = 7;
    
    public ElementalBlob(int lvl) {
        super((int)(BASE_HP * lvl * 0.30), (int)(BASE_ATK * lvl * 0.25), lvl, "Elemental Blob", "write description here", "write story here", null, null);
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println(this.getName() + " attacks with Elemental Throw (Basic attack)!");
        dmgAttack(opponent, atk);
    }


    
}
