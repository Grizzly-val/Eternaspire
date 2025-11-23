package mechanics.battleMechanics.battle;

import entity.Entity;
import entity.player.Challenger;
import entity.tower_entity.TowerEntity;
import mechanics.cutscene.CutsceneManager;
import ui.Format;
import ui.OptionSelect;

public class Battle {
    private final Challenger CHALLENGER;
    private final TowerEntity TOWER_ENTITY;

    // Column width for each battle column (expanded for clean fitting)
    private static final int COL_WIDTH = 56;

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

    // ---------------------------------------------------------
    // BEAUTIFIED DISPLAY HELPERS
    // ---------------------------------------------------------



    // Fit string to COL_WIDTH (trim or pad)
    private String fit(String text) {
        if (text.length() > COL_WIDTH)
            return text.substring(0, COL_WIDTH - 3) + "...";  // trim with dots
        return String.format("%-" + COL_WIDTH + "s", text);   // pad
    }

    private void printBattleStatus() {

        String leftName  = CHALLENGER.getName() + " (Lvl " + CHALLENGER.getLvl() + ")";
        String rightName = TOWER_ENTITY.getName() + " (Lvl " + TOWER_ENTITY.getLvl() + ")";

        String leftHp  = "HP: " + CHALLENGER.getHp() + " / " + CHALLENGER.getMaxHp();
        String rightHp = "HP: " + TOWER_ENTITY.getHp() + " / " + TOWER_ENTITY.getMaxHp();

        String weapon = (CHALLENGER.getEquippedWeapon() != null)
                ? "Weapon: " + CHALLENGER.getEquippedWeapon().getName()
                : "Weapon: NONE";

        String sp = "SP: " + CHALLENGER.getSkillPts();

        System.out.println("\n=======================================================================================================================");
        System.out.printf("| %s | %s |\n", fit(leftName), fit(rightName));
        System.out.printf("| %s | %s |\n", fit(leftHp),   fit(rightHp));
        System.out.printf("| %s | %s |\n", fit(weapon),    fit(""));
        System.out.printf("| %s | %s |\n", fit(sp),        fit(""));
        System.out.println("=======================================================================================================================\n");
    }


    // ---------------------------------------------------------
    // BATTLE FLOW
    // ---------------------------------------------------------

    public void start(){

        if(!CHALLENGER.getEncountered_Entities().contains(TOWER_ENTITY.getName())){
            encounterCutscene("cutscene_FirstEncounterWith_" 
                              + TOWER_ENTITY.getName().replace(" ", ""), 
                              CHALLENGER);
        }

        System.out.println("\n==============================================================");
        System.out.println("| BATTLE START");
        System.out.println("| Opponent: " + TOWER_ENTITY.getName());
        System.out.println("==============================================================\n");

        while(CHALLENGER.isAlive() && TOWER_ENTITY.isAlive()) {

            printBattleStatus();
            challengerTurn();

            System.out.println();
            System.out.println();

            if(TOWER_ENTITY.isAlive())
                towerEntityTurn();
        }

        // Result Phase
        CHALLENGER.resetLastDamage();
        TOWER_ENTITY.resetLastDamage();

        if(!CHALLENGER.isAlive()){
            System.out.println("----------------------------------------------------------------");
            System.out.println();
            System.out.println();
            CHALLENGER.defeated(CHALLENGER, this);
        }
        else if(!TOWER_ENTITY.isAlive()){
            System.out.println("----------------------------------------------------------------");
            System.out.println();
            System.out.println();
            TOWER_ENTITY.defeated(CHALLENGER, this);
        }
    }

    // ---------------------------------------------------------
    // PLAYER TURN
    // ---------------------------------------------------------

    public void challengerTurn(){
        System.out.println("------------------------------");
        System.out.println("| Attack |");
        System.out.println("----------");
        System.out.println("[a] Normal Attack");
        System.out.println("[s] Use Skill");
        System.out.println("------------------------------");

        char choice = '\0';
        while(choice != 'a' && choice != 's'){
            choice = OptionSelect.charInput('\0');
            System.out.println("--------------------------------");

            if(choice == 'a' || choice == 's') 
                Format.printSection(CHALLENGER.getName() + "'s TURN");

            switch(choice){
                case 'a':
                    CHALLENGER.basicAttack(TOWER_ENTITY);
                    break;
                case 's':
                    CHALLENGER.useActiveSkill(TOWER_ENTITY, this);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

        CHALLENGER.usePassiveSkill(CHALLENGER, this);
    }

    // ---------------------------------------------------------
    // ENEMY TURN
    // ---------------------------------------------------------

    public void towerEntityTurn(){
        Format.printSection(TOWER_ENTITY.getName() + "'s TURN");
        TOWER_ENTITY.useActiveSkill(CHALLENGER, this);
        TOWER_ENTITY.usePassiveSkill(CHALLENGER, this);
    }

    // ---------------------------------------------------------
    // REPEAT TURN FOR SKILLS
    // ---------------------------------------------------------

    public void repeatTurn(Entity who){
        if(who instanceof Challenger){
            challengerTurn();
        }
        else if(who instanceof TowerEntity){
            towerEntityTurn();
        }
    }

}
