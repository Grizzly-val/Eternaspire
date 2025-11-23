package world.location.locationData;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import engine.Game;
import world.location.Area;
import world.location.Floor;

public final class FloorData implements Serializable{

    private final Map<Integer, Floor> floors = new HashMap<>();

    // Initialize floors and areas once at program start
    public void init(Object game) {
        if(!(game instanceof Game)) return;
        addFloor(0, "The Beginning of No End", "Eternaspire's Entry Point", "nolock");
        addFloor(1, "The Platform of Nadir", "A still platform at the spiral's starting end.", "FloorLock_ThePlatformOfNadir");
        addFloor(2, "The Lower Ascent", "The first true upward climb of the spire, where the spiral steepens and the summit first appears impossibly distant.", "FloorLock_TheLowerAscent");
        addFloor(3, "The Ruined Kingdom of Neferis", "Endless sandstorms rage around the shattered remains of an ancient desert city.", "FloorLock_TheRuinedKingdomOfNeferis");
        addFloor(4, "The Pyramid of Osarion", "A colossal pyramid in the heart of the ruined kingdom, the final resting place of a tyrant king.", "FloorLock_ThePyramidOfOsarion");


        // Initialize areas
        getFloor(0).addArea(new Area("The Lobby of Descent", "The start of the spiral", "nolock"));

        // Floor 1
        getFloor(1).addArea(new Area("The Suspension Gate", "Narrow walkways above a black void", "AreaLock_TheSuspensionGate"));
        getFloor(1).addArea(new Area("The Shattered Span", "Broken bridge between two pillars of light", "AreaLock_TheShatteredSpan"));

        // Floor 2
        getFloor(2).addArea(new Area("The Climb of Echoes", "Steep incline filled with resonating stones", "AreaLock_TheClimbOfEchoes"));
        getFloor(2).addArea(new Area("The Hall of Whispers", "You hear whispers from unknown entities, they seem to warn you...","nolock"));


        // Floor 3
        getFloor(3).addArea(new Area("The Dune Sea", "Vast desert with shifting sands and hidden dangers", "nolock"));
        getFloor(3).addArea(new Area("The Oasis of Illusions", "A mirage-like oasis that plays tricks on weary travelers", "nolock"));
        getFloor(3).addArea(new Area("Entrance to Neferis", "The grand entrance to the ruined city, an eerie wind blows", "AreaLock_EntranceToNeferis"));


        // Floor 4
        getFloor(4).addArea(new Area("The Labyrinth", "A twisting maze of stone and shadow, where every turn hides a new danger.", "AreaLock_TheLabyrinth"));
        getFloor(4).addArea(new Area("The Pharaoh's Chamber", "The final resting place of Osarion, filled with ancient treasures and deadly traps.", "AreaLock_ThePharaohsChamber"));
        

        
    }



    private void addFloor(int n, String name, String description, String lockID) {
        floors.put(n, new Floor(n, name, description, lockID));
    }

    public Floor getFloor(int key) {
        return floors.get(key);
    }
}