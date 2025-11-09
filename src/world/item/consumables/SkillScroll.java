package world.item.consumables;

import entity.player.Challenger;
import mechanics.battleMechanics.skill.Skill;

public class SkillScroll extends Consumables{

    private Skill newSkill;
    public SkillScroll(String cutsceneID, Skill newSkill) {
        super("Skill Scroll", "Read to learn new skill", "Scroll", cutsceneID);
        this.newSkill = newSkill;
    }

    @Override
    public void consume(Challenger player) {
        System.out.println("You've learned " + newSkill.getName() + "!");
        System.out.println(newSkill.getDescription());
        player.learnSkill(newSkill);
        player.getInventory().remove(this);
    }
    
}
