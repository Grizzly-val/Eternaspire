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
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    public Item selectItem() {
        if (items.isEmpty()) return null;

        int choice = -1;
        Item selected = null;


        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + " - " + items.get(i).getName());
        }

        System.out.println("--------------------------------------------");
        
            choice = OptionSelect.getArrIndex(items.size());
            if (choice - 1 >= 0 && choice - 1 < items.size()) {
                selected = items.get(choice - 1);
            } else {
                System.out.println("Invalid choice. Try again.");
            }

            return selected;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
