package world.item.consumables;

import entity.player.Challenger;
import mechanics.battleMechanics.skill.Skill;

public class SkillScroll extends Consumables{

    private Skill newSkill;
    public SkillScroll(String cutsceneID, Skill newSkill) {
        super("Skill Scroll", "Read this scroll to permanently acquire the skill: " + newSkill.getName(), cutsceneID, 2);
        this.newSkill = newSkill;
    }
    public Skill getSkill(){return newSkill;}

    @Override
    public void consume(Challenger player) {
        System.out.println("| You learned " + newSkill.getName() + "!");
        System.out.println("> " +newSkill.getDescription());
        player.learnSkill(newSkill);
        player.getInventory().remove(this);
    }
    
}
