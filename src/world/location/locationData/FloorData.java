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
        addFloor(5, "The Glacial Gates", "This formidable entry hall guards the castle's secrets with treacherous, shifting ice and bottomless, windswept chasms.", "FloorLock_TheGlacialGates");
        addFloor(6, "The Sanctum of Sorrow", "Within these hallowed, silent chambers, the very walls feed on regret and a frozen heart pulses with the castle's ancient grief.", "FloorLock_TheSanctumOfSorrow");


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
        

        // Floor 5
        getFloor(5).addArea(new Area("The Crystalline Vestibule", "An open area surrounded by towering ice walls, with treacherous footing.", "nolock"));
        getFloor(5).addArea(new Area("The Weeping Chasm", "A vast, echoing split in the castle's foundation, bridged only by a treacherous arch of ice that weeps with constant, freezing meltwater.", "AreaLock_TheIceboundHall"));

        // Floor 6
        getFloor(6).addArea(new Area("The Mirror of Regret:", "A hall of flawless black ice that reflects not your face, but the haunting visage of your past failures and deepest shames.", "nolock"));
        getFloor(6).addArea(new Area("The Heartfrost Spire", " A cylindrical chamber where the castle's frozen core beats like a captured heart, radiating waves of palpable, soul-numbing sorrow.", "AreaLock_TheHeartfrostSpire"));
        getFloor(6).addArea(new Area("The Throne of Eternal Stillness", "A void of absolute silence and frozen time, where the Glacial Primarch sits upon a throne of black ice, embodying the end of all warmth and motion.", "AreaLock_TheThroneOfEternalStillness"));

    }



    private void addFloor(int n, String name, String description, String lockID) {
        floors.put(n, new Floor(n, name, description, lockID));
    }

    public Floor getFloor(int key) {
        return floors.get(key);
    }
}