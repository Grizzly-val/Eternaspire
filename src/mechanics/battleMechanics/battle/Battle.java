package mechanics.battleMechanics.battle;

import entity.player.Challenger;
import entity.tower_entity.TowerEntity;
import ui.OptionSelect;

public class Battle {
    private final Challenger CHALLENGER;
    private final TowerEntity TOWER_ENTITY;

    public Battle(Challenger challenger, TowerEntity towerEntity) {
        this.CHALLENGER = challenger;
        this.TOWER_ENTITY = towerEntity;
        start();
    }

    public Challenger getChallenger(){return CHALLENGER;}
    public TowerEntity getTowerEntity(){return TOWER_ENTITY;}



    public void start(){
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("| Battle Begin!");
        System.out.println("| Opponent: " + getTowerEntity().getName());
        System.out.println("----------------------------------");
        System.out.println();

        while(CHALLENGER.isAlive() && TOWER_ENTITY.isAlive()){
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("[" + getChallenger().getName() + "]                                    [" + getTowerEntity().getName() + "]");
            System.out.println("HP: " + getChallenger().getHp() + "                                            HP: " + getTowerEntity().getHp());
            System.out.println("SP: " + getChallenger().getSkillPts());
            System.out.println("------------------------------------------------------------------------------------------------------");

            challengerTurn();
            
            if(TOWER_ENTITY.isAlive()) 
                towerEntityTurn();
        }

        if(!CHALLENGER.isAlive()){
            CHALLENGER.defeated(this);
        }
        else if(!TOWER_ENTITY.isAlive()){
            TOWER_ENTITY.defeated(this);
        }

    }

    public void challengerTurn(){
        System.out.println("| " + CHALLENGER.getName() + "'s turn");
        System.out.println("-------------------------------");
        System.out.println("[a] - Normal Attack");
        System.out.println("[s] - Use Skill");
        System.out.println("-------------------------------");

        char choice = '\0';
        while(choice != 'a' && choice != 's'){
            choice = OptionSelect.charInput('\0');
            System.out.println("-----------------------------------------------------------");
            switch(choice){
                case 'a':
                    CHALLENGER.basicAttack(TOWER_ENTITY);
                    System.out.println("-----------------------------------------------------------");
                    break;
                case 's':
                    CHALLENGER.useActiveSkill(this);
                    System.out.println("-----------------------------------------------------------");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        
    }

    public void towerEntityTurn(){

        TOWER_ENTITY.useActiveSkill(this);
        TOWER_ENTITY.usePassiveSkill(this);

    }

}
