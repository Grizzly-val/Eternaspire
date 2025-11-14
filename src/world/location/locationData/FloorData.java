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

        // Initialize areas
        getFloor(0).addArea(new Area("The Lobby of Descent", "The start of the spiral", "nolock"));

        getFloor(1).addArea(new Area("The Suspension Gate", "Narrow walkways above a black void", "AreaLock_TheSuspensionGate"));
        getFloor(1).addArea(new Area("The Shattered Span", "Broken bridge between two pillars of light", "AreaLock_TheShatteredSpan"));

        
    }


    private void addFloor(int n, String name, String description, String lockID) {
        floors.put(n, new Floor(n, name, description, lockID));
    }

    public Floor getFloor(int key) {
        return floors.get(key);
    }
}
