# ✨🗼 Eternaspire: Conquer the Tower 🗼✨

> **"The only limit is the challenger’s own imagination."**

---

## 📜 Game Overview

Eternaspire is a **turn-based role-playing game** (RPG). Players choose an avatar to ascend a tower that is said to grant anyone who conquers it a wish. Be it wealth, power, or knowledge—the potential reward is limitless.

As you embark on your ascent, you will uncover fragments of the tower’s secrets and the stories behind the daring challengers who came before you.

---

## ⚙️ Project Details

* **Course Code:** CS-211 📝

---

## 👥 Development Team 🐛🚀

* **Donatos, Trixter Lanz**
* **Ilao, Kent Patrick**
* **Villanueva, Franz Daniel**
___


# ✦ Overview ✦

**Eternaspire is a console-based, text-only, turn-based role-playing game built in Java.**

Players **choose an avatar** and ascend a** mysterious tower** said to grant any wish to those who conquer it. Whether seeking wealth, power, or knowledge, the only limit is the challenger’s imagination.

As players climb the tower, they uncover fragments of its secrets and the stories of daring challengers who came before. The game combines strategic turn-based combat with exploration and storytelling, **all through a simple console interface.**

**Can you conquer this Tower?**

___



This project showcases Java programming concepts such as object-oriented design, classes, inheritance, encapsulation, and control flow, along with user input handling and game logic.

**Players Can:**

⚔️ - **Pick a class from three characters!**
- **Blade**             ♙  : the Mercenary
- **Percival**          ♘  : The Knight
- **Another Percival**  ♗  : The Paladin

📈 - **Fight** remnants and echoes to level up their hp and attack as well as uncover hidden lore of the tower!

🔎 - **Explore** through ten floors, each with varying number of area and collect valuable loot!

📁 - **Create New Accounts and Games** Establish your legacy! Start a fresh journey with a new character, or manage multiple ongoing adventures under one player profile.

💾 - **Save Accounts and Games** Secure your progress instantaneously! Your game state and character data are automatically backed up to the cloud after major milestones.

___

# ✦ Project Structure ✦

## ✦ Features ✦
*🛡️ **Choose Your Job*** – Pick from three unique classes, each with different base stats and background stories.    

*❤️ **HP*** – Fight for your own, deplete theirs.

*⚡**SP*** – Special moves are not free

*⬆️⬇️ **Ascend or Descend Floors*** – Explore various areas on each floor of the tower.

*⭐ **Experience Points (XP)*** – Earn XP to level up, increasing HP and SP. Leveling up fully restores HP and SP.

*💰 **Collect Loot*** – Obtain items from remnants, echoes, chests, rubble, or random drops.  
___
*✨ **Skills:***  
  - *🎯 **Active Skills*** – Activated by the player and consume SP.  
  - *🛡️ **Passive Skills*** – Automatically activates per turn and do not consume SP. Occurance of a passive skill relies on chance.
___
*👹 **Enemies:*** 

  - *🗡️ **Remnants*** – Common foe entities scattered throughout the floors.  
  - *💀 **Echoes*** – Bosses that are strongr than remnants and guard each floor.
  *They are explained in the cutscenes!*
___
*🎒 **Inventory System:*** – Manage items classified as:
 - *🔑 **Keys*** – Unlock floors and areas. 
 - *⚔️ **Weapons*** – Equip to strengthen characters, each with unique passives. 
 - *📜 **Skill Scrolls*** – Learn powerful skills for damage or healing.
 - *🍞 **Foods*** – Recover HP or SP.
*Our Inventory System also features a capacity mechanic, limiting the number of items a player can carry—adding a layer of strategy when deciding what to keep or discard.*
___

### Several in-game events trigger unique cutscenes that deepen the story and provide context for the player’s journey 🧾🎬. These include:
- *📖 Opening Cutscenes different for each characters*
- *🔑 Using a **Key***
- *🍎 Eating Certain **Foods***
- *⚔️ Picking Up a **Weapon** for the First Time*
- *👹 First Encounter with a **Remnant***
- *🗡️ First Defeat of a **Remnant***
- *💀 **Echo** Encounters*
- *⭐ Defeating an **Echo***
*These cutscenes enrich the lore of Eternaspire, revealing character motives, tower mysteries, and the*

___


## Accound Data Storage 💾☁️
**Account data are stored as a DAT file.**
**Saving Progress** – *Save your game via the inventory menu to resume later.* > This might help against that one Echo 💀💀💀

> <img width="132" height="77" alt="image" src="https://github.com/user-attachments/assets/683610ed-00f9-47e4-9ce1-14daef63ab2e" />


### How to save game progress?
- **0** in **Inventory Mode**
- **Exiting game manually in floor navigation mode** automatically saves current game progress
> **Forcibly terminating** the program does not save current progress.


___








```
📁 ETERNASPIRE
│
├── 🗂️ .vscode
├── 📦 bin
├── 📚 lib
│
└── 📁 src
    │
    ├── ⚙️ engine
    │   ├── Account.java
    │   ├── AccountManager.java
    │   ├── Game.java
    │   └── GameResult.java
    │
    ├── 👤 entity
    │   ├── player
    │   │   ├── Challenger.java
    │   │   ├── Knight.java
    │   │   ├── Mercenary.java
    │   │   └── Paladin.java
    |   |  
    │   └── tower_entity
    │   |        ├── echoes
    |   |        |      └── [Specific echoes]
    │   |        └── remnants
    |   |        |       └── [Specific remnants]
    │   |        ├── Remnant.java
    |   |        ├── Echo.java
    |   |        └── TowerEntity.java
    |   |
    |   └── Entity.java
    |
    ├── ⚔️ mechanics
    │   ├── battle — Battle.java
    │   ├── skill
    |   │     ├── active_skills
    |   |     |       ├── dropped — [Specific dropped active skills]
    |   |     |       └── [Specific active skills]
    |   │     └── passive_skills
    |   |     |       ├── dropped — [Specific dropped passive skills]
    |   |     |       └── [Specific passive skills]
    │   │     ├── ActiveSkill.java
    │   │     └── PassiveSkill.java
    │   │     └── Skill.java
    |   |
    │   ├── Inventory
    │   │   ├── AreaInventory.java
    │   │   ├── Inventory.java
    │   │   └── PlayerInventory.java
    │   ├── pstate
    │   │   ├── AreaNavigationState.java
    │   │   ├── FloorNavigationState.java
    │   │   ├── IdleAreaState.java
    │   │   ├── InventoryState.java
    │   │   └── PlayerState.java
    │   └── cutscene — CutsceneManager.java
    │
    │
    ├── 🌎 world
    │   ├── item
    │   │   └── Item.java
    |   |   │     ├── consumables
    |   |   │     │     ├── Consumables.java
    |   |   │     │     ├── Food.java
    |   |   │     │     ├── FoodEffect.java
    |   |   │     │     ├── Key.java
    |   |   │     │     └── SkillScroll.java
    |   |   │     └── wpn
    |   |   |          ├── Weapon.java
    |   |   |          └── [Specific weapons]
    |   |   └── Item.java
    |   |
    |   |
    |   └── 📍 location
    |       ├── Area.java
    |       ├── Floor.java
    |       ├── Location.java
    |       └── locationData
    |               ├── FloorData.java
    |               ├── AreaInventoryData.java
    |               ├── AreaEntityData.java
    |               └── AreaEntities.java               
    |   
    ├── 🎨 ui
    │   ├── AudioPlayer.java
    │   ├── Format.java
    │   ├── OptionSelect.java
    │   └── TextTyper.java
    │
    ├── 🖼️ resources
    │   ├── background_audio — [Background_audios.wav]
    │   └── cutscenes — [Cutsences.txt]
    │
    ├── Main.java
    ├── [gameName]_game_save.dat
    └── accounts.dat
    
```



















___


# ✦ Object-Oriented Design Principles 💻🏰

> This project utilizes core Object-Oriented Programming (OOP) principles to create a modular, scalable, and maintainable game architecture. Below is an overview of how these principles are applied to the codebase.

___

## 1. Encapsulation🔒📦

- 🛡️ We utilize access modifiers to restrict direct access to object components and bundle data with the methods that operate on that data. This ensures data integrity and prevents external classes from putting an object into an invalid state.
- 🛡️ Entity Data Security: Core attributes within the Entity class (lvl, hp, atk, maxHP) are marked as protected. This allows specific subclasses like Remnant or Mercenary to manipulate their own stats during initialization or combat, while keeping them safe from unrelated utility classes. 🛡️
- 🛡️ Identity Isolation: Properties such as name and description are kept private within specific implementations to ensure unique identity immutability after instantiation. 🧩
- 🛡️ Inventory Management: The Inventory class encapsulates the logic for storing items, exposing only necessary methods to add or remove items, while hiding the underlying data structures for PlayerInventory and AreaInventory. 🎒


___

 
## 2. Inheritance 🌳📚
#### 🧩 Class Hierarchy Overview
* 🧬 A hierarchical structure is used to promote code reusability and establish **"is-a"** relationships. Common logic is defined in parent classes, while specific behaviors are pushed down to child classes.
Class Hierarchy Overview:

___


#### Entity System 👤⚔️:
- **Entity** (Base)
- TowerEntity → Echo / Remnant → SpecificEcho / SpecificRemnant
- Challenger → Mercenary / Knight / Paladin
```
👤 Entity (Abstract Base Class)
 │    (Logic: Contains essential methods like Update(), Draw(), GetPosition())
 │
 ├── 👾 TowerEntity (Abstract Enemy Class)
 │    │
 │    ├── 💀 Remnant (Specific Enemy Type)
 │    │    └── 💀👻 SpecificRemnant (Concrete Enemy, e.g., 'ElementalBlob')
 │    │
 │    └── 👥 Echo
 │         └── 👥🌫️ SpecificEcho (Concrete Enemy, e.g., 'Gnawer')
 │
 └── 🛡️ Challenger (Player/Major NPC Class)
      │
      ├── 💰 Mercenary
      │
      ├── 🐴 Knight
      │
      └── ✨ Paladin
```





#### Item System 🗡️🍎:
```
Item (Base Class)
 │
 ├── ⚔️ Weapon
 │    │
 │    └── 🗡️ SpecificWeapon (Each has unique passive logic)
 │
 └── 🧪 Consumable (Logic: Destroy/Decrement quantity on use)
      │
      ├── 🍗 Food (Effect: HP/SP/XP)
      │
      ├── 📜 Skill Scroll (Logic: Add "Skill" object to Player when consumed)
      │
      └── 🗝️ Key (Logic: Check ID against Location (i.e. Area/Floor); remove after use)
```





#### Skill System ✨📜:
```
⚡ Skill (Abstract Base Class)
 │
 ├── 💥 ActiveSkill (Manual Execution)
 │    │
 │    │
 │    └── ⚙️ Concrete Active Skills (Varying effects/SP use)
 │
 └── 🌟 PassiveSkill (Automatic/Always Active/Checks Condition)
      │
      └── ⚙️ Concrete Passive Skills (Varying effects/conditions)
```





## Location System 🗺️🏞️:
*Note: Floor manages a collection of Area objects.*
```
🗺️ Location (Abstract Base Class)
 │    (Logic: Contains essential spatial properties: Global ID, Coordinates, Name)
 │
 ├── 🪜 Floor (Major Spatial Container)
 │
 └── 🚪 Area (Specific Zone/Room)
```




___


## 3. Polymorphism 🔄

- **State Pattern:** The PlayerState interface is implemented by AreaNavigationState, FloorNavigationState, IdleAreaState, and InventoryState. The main game loop interacts with the generic PlayerState interface, allowing the player to switch contexts seamlessly without changing the core engine loop. 🔁
- **Combat System:** The Battle class is instantiated generically. It can initiate a fight between a Challenger and any TowerEntity. The battle logic calls methods like attack() or useSkill(), and the specific object (Knight vs SpecificRemnant) determines the actual damage calculation or effect execution. ⚔️🔥
- **Skill Execution:** Both ActiveSkill and PassiveSkill extend Skill. The combat system iterates through a list of Skill objects, invoking their effects. A healing skill and a damage skill are treated uniformly by the invoker, but behave differently upon execution.💥💖 

## 4. Abstraction 🎭📁

- **Utility Managers:** Classes like CutsceneManager, AudioPlayer, and TextTyper act as black boxes. The game logic simply requests "Play Audio" or "Type Text," without needing to understand the underlying timing logic or rendering algorithms. 🎬🔊⌨️
- **UI Components:** OptionSelect and Format static classes abstract away the complexity of formatting strings and handling user input indices, providing a clean user interface. 🖥️✨
- **Game Flow:** The Battle class abstracts the complexity of turn-based logic. The main game loop triggers a battle, and the Battle class handles the minute details of turn order, damage calculation, and win/loss states internally. 🕒⚔️🏆

___


# How to run Eternaspire
- Clone this Repository to have it locally on your computer
- In the terminal of the **root folder** "Eternaspire", enter ***java -cp bin Main***
> <img width="411" height="50" alt="image" src="https://github.com/user-attachments/assets/ada87e2d-18f1-4566-ad69-8b635d7f6b34" />
- **Enjoy!** *(Important)*

