package world.item.consumables;

import entity.player.Challenger;
import mechanics.battleMechanics.skill.Skill;
import mechanics.cutscene.CutsceneManager;

public class SkillScroll extends Consumables{

    private Skill newSkill;
    public SkillScroll(String cutsceneID, Skill newSkill, String name) {
        super(name, "Read this scroll to permanently acquire the skill: " + newSkill.getName(), cutsceneID, 2);
        this.newSkill = newSkill;
    }
    public Skill getSkill(){return newSkill;}

    @Override
    public void consume(Challenger player) {
        triggerCutscene(getCutsceneID(), player);
        System.out.println("| You learned " + newSkill.getName() + "!");
        System.out.println("> " +newSkill.getDescription());
        player.learnSkill(newSkill);
        player.getInventory().remove(this);
    }
    @Override
    public void triggerCutscene(String cutsceneID, Challenger player) {
        System.out.println();
        CutsceneManager.checkCutscene(cutsceneID, player);
        System.out.println();
    }
    
}
