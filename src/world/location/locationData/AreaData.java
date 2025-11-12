package world.location.locationData;

import world.location.Area;
import world.location.Floor;

public final class AreaData {

    // isParentArea is always true here
    // if Area is ParentArea, player can goUp and goDown.

    static{
        Floor floorPtr = FloorData.getFloor(0); //  Zeroth Floor
            floorPtr.addArea(new Area("The Lobby of Descent", "The start of the spiral", "nolock"));

        floorPtr = FloorData.getFloor(1);    //  First floor
            floorPtr.addArea(new Area("The Suspension gate", "Narrow walkways suspended above a black void.", "nolock"));
            floorPtr.addArea(new Area("The Shattered Span", "A broken bridge hanging between two pillars of light.", "nolock"));   

    }
}
