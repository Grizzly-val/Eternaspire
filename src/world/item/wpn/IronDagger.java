package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class IronDagger extends Weapon {
    public IronDagger(){
        super("Iron Dagger", "A reliable weight for the pocket. It won't win you a duel, but it's perfect for when subtlety is more important than strength.", "cutscene_FirstTimeEquip_IronDagger", 9);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("A silent jab with the crude Iron Dagger's blade.");
        user.dmgAttack(opponent, atk);

        String[] moves = {"Stab", "Slash", "Impale"};
        String move = "";

        int totalDmg = 0;
        int counter = 0;
        for(int i = 0; i < 7; i++){
            if(Math.random() < 0.2){
                try{
                    move = moves[(int)(Math.random() * 1000) % 3];
                } catch(IndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                    break;
                }
                System.out.print("| " + move + "! ");
                int hitDmg = 0;
                switch(move){
                    case "Stab":
                        hitDmg = (int)(atk * 0.1);
                        totalDmg += hitDmg;
                        System.out.println(hitDmg + "dmg");
                        break;
                    case "Slash":
                        hitDmg = (int)(atk * 0.2);
                        totalDmg += hitDmg;
                        System.out.println(hitDmg + "dmg");
                        break;
                    case "Impale":
                        hitDmg = (int)(atk * 0.33);
                        totalDmg += hitDmg;
                        System.out.println(hitDmg + "dmg");
                        break;
                    default:
                        totalDmg += 0;
                        System.out.println("0dmg");
                        break;
                }
                counter++;

            }
        }

        if(totalDmg > 0 && counter > 0){
            System.out.println("| " + user.getName() + " followed a " + counter + " hit combo!");
            user.dmgAttack(opponent, totalDmg);
        }
    }
}
