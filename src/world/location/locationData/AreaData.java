package world.location.locationData;

import world.location.Area;
import world.location.Floor;

public final class AreaData {

    // isParentArea is always true here
    // if Area is ParentArea, player can goUp and goDown.

    static{
        Floor floorPtr = FloorData.getFloor(0); //  Zeroth Floor
            new Area("The Lobby of Descent", "The start of the spiral", "nolock").addArea(floorPtr);

        floorPtr = FloorData.getFloor(1);    //  First floor

    }
}
