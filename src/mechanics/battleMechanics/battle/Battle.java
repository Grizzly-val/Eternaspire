package mechanics.battleMechanics.battle;

import entity.Entity;
import entity.player.Challenger;
import entity.tower_entity.TowerEntity;
import mechanics.cutscene.CutsceneManager;
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


    public void encounterCutscene(String cutsceneID, Challenger player) {
        System.out.println();
        CutsceneManager.checkCutscene(cutsceneID, player);
        System.out.println();
    }


    public void start(){

        if(!CHALLENGER.getEncountered_Entities().contains(TOWER_ENTITY.getName())){
            System.out.println();
            encounterCutscene("cutscene_FirstEncounterWith_" + TOWER_ENTITY.getName().replace(" ", ""), CHALLENGER);
            System.out.println();
        }
        
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("| Battle Begin!");
        System.out.println("| Opponent: " + TOWER_ENTITY.getName());
        System.out.println("----------------------------------");
        System.out.println();

        while(CHALLENGER.isAlive() && TOWER_ENTITY.isAlive()){

            String combatFormat = "| %-35s | %-55s |";

            System.out.println("-------------------------------------------------------------------------------------------------");

            System.out.printf(combatFormat + "\n",
                "[" + CHALLENGER.getName() + "]",
                "[" + TOWER_ENTITY.getName() + "]"
            );

            String challengerHpWeapon = "\0";
            if(getChallenger().getEquippedWeapon() != null){
                challengerHpWeapon = "HP: " + CHALLENGER.getHp() + " | WPN: " + CHALLENGER.getEquippedWeapon().getName();
            } else{
                challengerHpWeapon = "HP: " + CHALLENGER.getHp() + " | WPN: " + "NONE";
            }
            

            String enemyHp = "HP: " + TOWER_ENTITY.getHp();
            
            System.out.printf(combatFormat + "\n",
                challengerHpWeapon,
                enemyHp
            );

            String challengerSp = "SP: " + getChallenger().getSkillPts();

            
            System.out.printf(combatFormat + "\n",
                challengerSp,
                ""
            );
            
            System.out.println("-------------------------------------------------------------------------------------------------");

            challengerTurn();
            
            if(TOWER_ENTITY.isAlive()) 
                towerEntityTurn();
        }

        if(!CHALLENGER.isAlive()){
            TOWER_ENTITY.resetLastDamage();
            CHALLENGER.resetLastDamage();
            CHALLENGER.defeated(CHALLENGER, this);
        }
        else if(!TOWER_ENTITY.isAlive()){
            TOWER_ENTITY.resetLastDamage();
            CHALLENGER.resetLastDamage();
            TOWER_ENTITY.defeated(CHALLENGER, this);
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
                    CHALLENGER.useActiveSkill(TOWER_ENTITY, this);
                    System.out.println("-----------------------------------------------------------");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

        CHALLENGER.usePassiveSkill(CHALLENGER, this);
        
    }

    public void towerEntityTurn(){

        TOWER_ENTITY.useActiveSkill(CHALLENGER, this);
        TOWER_ENTITY.usePassiveSkill(CHALLENGER, this);

    }



    public void repeatTurn(Entity who){
        if(who instanceof Challenger){
            challengerTurn();
        }
        else if(who instanceof TowerEntity){
            towerEntityTurn();
        }
    }

}
