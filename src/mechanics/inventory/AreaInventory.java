package mechanics.inventory;

import java.util.ArrayList;
import world.item.Item;
import ui.OptionSelect;

public class AreaInventory extends Inventory {

    private ArrayList<Item> items = new ArrayList<>();

    public AreaInventory(String name) {
        super(name);
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        if (items.remove(item)) {
            System.out.println(item.getName() + " removed from " + getName());
        } else {
            System.out.println(item.getName() + " not found in " + getName());
        }
    }

    public Item selectItem() {
        if (items.isEmpty()) return null;

        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + " - " + items.get(i).getName());
        }

        int choice = -1;
        Item selected = null;

        while (selected == null) {
            choice = OptionSelect.getArrIndex(items.size());
            if (choice - 1 >= 0 && choice - 1 < items.size()) {
                selected = items.get(choice - 1);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        return selected;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
