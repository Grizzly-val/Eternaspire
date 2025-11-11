import entity.player.Mercenary;
import ui.TextTyper;
import world.location.locationData.AreaData;
import world.location.locationData.AreaEntityData;
import world.location.locationData.AreaInventoryData;
import world.location.locationData.FloorData;

public class Main {
    public static void main(String[] args){
        System.out.println();

        initWorldData();

        System.out.println();
        
        Mercenary player = new Mercenary();

        player.play();
    }


    private static void initWorldData() {
        // These lines cause the classes to load & their static blocks to run
        Class<?>[] classes = {
            FloorData.class,
            AreaData.class,
            AreaEntityData.class,
            AreaInventoryData.class
        };

        for (Class<?> c : classes) {
            try {
                Class.forName(c.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println("✅ All world data initialized!");
    }
}