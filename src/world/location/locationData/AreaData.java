package world.location.locationData;

import world.location.Area;

public final class AreaData {

    // isParentArea is always true here
    // if Area is ParentArea, player can goUp and goDown.

    static{
        new Area("Ground Floor Area One", "Ground Floor Area One Description", "nolock").addArea(FloorData.getFloor(0));
        new Area("Floor 1 Area One", "Floor 1 Area One Description", "nolock").addArea(FloorData.getFloor(1));
        new Area("Floor 1 Area Two", "Floor 1 Area Two Description", "nolock").addArea(FloorData.getFloor(1));
    }
}
