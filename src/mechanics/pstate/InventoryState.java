package mechanics.pstate;

import entity.player.Challenger;
import mechanics.battleMechanics.skill.ActiveSkill;
import mechanics.battleMechanics.skill.PassiveSkill;
import ui.OptionSelect;
import world.item.consumables.Food;
import world.item.consumables.Key;
import world.item.consumables.SkillScroll;
import world.item.wpn.Weapon;

public class InventoryState implements PlayerState{
    @Override
    public void enterState(Challenger player) {
        System.out.println();
        System.out.println();
        System.out.println("-----------------");
        System.out.println("| | Inventory | |");
        System.out.println("-----------------");

        char choice = '\0';

        while(choice != 'b'){
            System.out.println();
            String statFormat = "|> %-6s :   %-10s |> %-4s :   %-10s |> %-6s :   %s";

            System.out.println("|> Name   :   " + player.getName());
            System.out.println("|> Job    :   " + player.getJob());


            System.out.printf(statFormat + "\n", 
                "HP", player.getHp(), 
                "SP", player.getSkillPts(), 
                "ATK", player.getAtk()
            );

            
            System.out.println(String.format("|> %-6s :   %-10s |> %-4s :   %s/%s      |> %-6s :   %s",
                    "LVL", player.getLvl(),
                    "XP", player.getXp(), player.getMaxXp(),
                    "INV", player.getInventory().getOccupiedSpace() + "/" + player.getInventory().getCapacity()
                ));

            if(player.getEquippedWeapon() != null) System.out.println("|> Weapon : " + player.getEquippedWeapon().getName());
            else System.out.println("|> Weapon : NONE");
            
            System.out.println("----------------------------------------");
            System.out.println("[b] - Go back       (Exit inventory)");
            System.out.println("[l] - skill list    (Check skills)");
            System.out.println("----------------------------------------");
            System.out.println("[f] - Food          (Consume food)");
            System.out.println("[w] - Weapon        (Equip Weapon)");
            System.out.println("[s] - Skill Scroll  (Learn skill)");
            System.out.println("[k] - key           (Check keys)");
            System.out.println("----------------------------------------");
            System.out.print("| Select Inventory Section >> ");
            choice = OptionSelect.charInput(choice);
            switch(choice){
                case 'b':

                    System.out.println("----------------------------------------");
                    System.out.println();
                    System.out.println("| Exitting inventory >>");
                    System.out.println();
                    break;

                case 'l':
                    System.out.println("----------------------------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("----------------");
                    System.out.println("|Active Skills|");
                    System.out.println("----------------");
                    int i = 1;
                    if(player.getActiveSkillSet().isEmpty()){
                        System.out.println("| Active skill set is empty");
                    }
                    else{
                        for(ActiveSkill aSkill : player.getActiveSkillSet()){
                        System.out.println("| " + i++ + ". " + aSkill.getName() + "[" + aSkill.getPtUse() + "sp]");
                        System.out.println("\t| " + aSkill.getDescription());
                        }    
                    }

                    System.out.println();
                    System.out.println("----------------");
                    System.out.println("|Active Skills|");
                    System.out.println("----------------");
                    if(player.getPassiveSkillSet().isEmpty()){
                        System.out.println("| Passive skill set is empty");
                    }
                    else{
                        i = 1;
                        for(PassiveSkill pSkill : player.getPassiveSkillSet()){
                            System.out.println("| " + i++ + ". " + pSkill.getName());
                            System.out.println("\t| " + pSkill.getDescription());
                        }
                    }
                    break;
                case 'f':
                    System.out.println();
                    Food food = player.getInventory().getFood();
                    System.out.println("----------------------------------------");
                    if(food != null){
                        System.out.println();
                        System.out.println("| Selected food : " + food.getName());
                        System.out.println("> " + food.getDescription());
                        System.out.println();
                        System.out.println("[d] - Drop skill scroll");
                        System.out.println("[e] - Eat food");
                        System.out.println("----------------------------------------");
                        switch(OptionSelect.charInput('\0')){
                            case 'd':
                                System.out.println("----------------------------------------");
                                System.out.println();
                                player.dropItem(player.getCurrentArea(), food);
                                break;
                            case 'e':
                                System.out.print("| Eat food >> ");
                                if(OptionSelect.yesOrNo()){
                                    System.out.println();
                                    System.out.println("----------------------------------------");
                                    food.consume(player);
                                }
                                else{
                                    System.out.println();
                                    System.out.println("| It's important to save food too...");
                                }
                                System.out.println();
                                break;
                            default:
                                break;
                        }
                    } else{
                        System.out.println();
                        System.out.println("| No food in inventory.");
                        System.out.println();
                    }
                    break;
                case 'w':
                    System.out.println();
                    Weapon wpn = player.getInventory().getWpn();
                    System.out.println("----------------------------------------");
                    if(wpn != null){
                        System.out.println();
                        System.out.println("| Selected weapon : " + wpn.getName());
                        System.out.println("> " + wpn.getDescription());
                        System.out.println();
                        System.out.println("[d] - Drop weapon");
                        System.out.println("[e] - equip weapon");
                        System.out.println("----------------------------------------");
                        switch(OptionSelect.charInput('\0')){
                            case 'd':
                                System.out.println("----------------------------------------");
                                System.out.println();
                                player.dropItem(player.getCurrentArea(), wpn);
                                break;
                            case 'e':
                                System.out.print("| Equip weapon >> ");
                                if(OptionSelect.yesOrNo()){
                                    System.out.println();
                                    System.out.println("----------------------------------------");
                                    wpn.equip(player);
                                }
                                else{
                                    System.out.println();
                                    System.out.println("| As long as you can defend yourself...");
                                }
                                System.out.println();
                                break;
                            default:
                                break;
                        }
                    } else{
                        System.out.println();
                        System.out.println("| No weapon in inventory.");
                        System.out.println();
                    }
                    break;
                case 's':
                    System.out.println();
                    SkillScroll skillScroll = player.getInventory().getSkillScroll();
                    System.out.println("----------------------------------------");
                    if(skillScroll != null){
                        System.out.println();
                        System.out.println("| Selected skill scroll : " + skillScroll.getName());
                        System.out.println("> " + skillScroll.getDescription());
                        System.out.println();
                        System.out.println("[d] - Drop skill scroll");
                        System.out.println("[u] - Learn skill");
                        System.out.println("----------------------------------------");
                        switch(OptionSelect.charInput('\0')){
                            case 'd':
                                System.out.println("----------------------------------------");
                                System.out.println();
                                player.dropItem(player.getCurrentArea(), skillScroll);
                                break;
                            case 'u':
                                System.out.print("| Learn skill >> ");
                                if(OptionSelect.yesOrNo()){
                                    System.out.println();
                                    System.out.println("----------------------------------------");
                                    skillScroll.consume(player);
                                }
                                else{
                                    System.out.println();
                                    System.out.println("| If you don't think you'll need it...");
                                }
                                System.out.println();
                                break;
                            default:
                                break;
                        }
                    } else{
                        System.out.println();
                        System.out.println("| No skill scroll in inventory.");
                        System.out.println();
                    }
                    break;
                case 'k':
                    System.out.println();
                    Key key = player.getInventory().getKey();
                    System.out.println("----------------------------------------");
                    if(key != null){
                        System.out.println();
                        System.out.println("| Key name          : " + key.getName());
                        System.out.println("> " + key.getDescription());
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("| No key in inventory.");
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println();
                    System.out.println("| | Invalid input | |");
                    System.out.println();
                    break;

            }







        }


    }
    
}
