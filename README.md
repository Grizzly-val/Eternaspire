<div align="center">
  <h1>✨🗼Eternaspire🗼✨</h1>
  <p>Eternaspire is a turn-based role-playing game. Choose an avatar to ascend a tower that is said to grant anyone who conquers it a wish. Be it wealth, power, or knowledge the only limit is the challenger’s       own imagination. As you ascend the tower, you uncover fragments of the tower’s secrets and the story behind the daring challengers.</p>
  <p>
   <b>CS-2102</b><br>
    Donatos, Trixter Lanz <br>
    Ilao, Kent Patrick <br>
    Villanueva, Franz Daniel
  <p> 
</div>

## ✦ Overview ✦

**Eternaspire is a console-based, text-only, turn-based role-playing game built in Java.**

Players **choose an avatar** and ascend a** mysterious tower** said to grant any wish to those who conquer it. Whether seeking wealth, power, or knowledge, the only limit is the challenger’s imagination. 

As players climb the tower, they uncover fragments of its secrets and the stories of daring challengers who came before. The game combines strategic turn-based combat with exploration and storytelling, **all through a simple console interface.**

**Can you conquer this Tower?**

This project showcases Java programming concepts such as object-oriented design, classes, inheritance, encapsulation, and control flow, along with user input handling and game logic.

**Players Can:**

⚔️ - **Pick a class from three characters!**
*
♟**Blade**: the Mercenary
♞**Percival**: The Knight
♗**Another Percival**: The Paladin
*
📈 - **Fight** remnants and echoes to level up their hp and attack as well as uncover hidden lore of the tower!    
🔎 - **Explore** through ten floors, each with varying number of area and collect valuable loot!



## ✦ Project Structure ✦

## ✦ Features ✦
*🛡️ **Choose Your Job*** – Pick from three unique classes, each with different base stats and background stories.    
*❤️ **HP*** – Fight for your own, deplete theirs.
*⚡**SP*** – Special moves are not free
*⬆️⬇️ Ascend or Descend Floors* – Explore various areas on each floor of the tower.  
*⭐ **Experience Points (XP)*** – Earn XP to level up, increasing HP and SP. Leveling up fully restores HP and SP.
*💰 **Collect Loot*** – Obtain items from remnants, echoes, chests, rubble, or random drops.   
*🪄 **Skills:***  
  *🎯 **Active Skills*** – Activated by the player and consume SP.  
  *🛡️ **Passive Skills*** – Automatically activates per turn and do not consume SP. Occurance of a passive skill relies on chance.

*👹 **Enemies:*** 
  *🗡️ **Remnants*** – Common foe entities scattered throughout the floors.  
  *💀 **Echoes*** – Bosses that are strongr than remnants and guard each floor.s
  *They are explained in the cutscenes!*

*🎒 Inventory System:** – Manage items classified as:
  *🔑 Keys** – Unlock floors and areas. 
   *⚔️ Weapons* – Equip to strengthen characters, each with unique passives. 
  *📜 Skill Scrolls** – Learn powerful skills for damage or healing.
  *🧪 Foods** – Recover HP or SP.
*Our Inventory System also features a capacity mechanic, limiting the number of items a player can carry—adding a layer of strategy when deciding what to keep or discard.*


# Several in-game events trigger unique cutscenes that deepen the story and provide context for the player’s journey. These include:
*📖 Opening Cutscenes different for each characters*
*🔑 Using a Key*
*🍎 Eating Certain Foods*
*⚔️ Picking Up a Weapon for the First Time*
*👹 First Encounter with a Remnant*
*🗡️ First Defeat of a Remnant*
*💀 Echo Encounters*
*⭐ Defeating an Echo*
*These cutscenes enrich the lore of Eternaspire, revealing character motives, tower mysteries, and the*


*Accound Data Storage*
Account data are stored as a DAT file.
*💾 Saving Progress* – Save your game via the inventory menu to resume later. This might help against that one Echo 💀💀💀

# ✦ Object-Oriented Design Principles 💻🏰

This project utilizes core Object-Oriented Programming (OOP) principles to create a modular, scalable, and maintainable game architecture. Below is an overview of how these principles are applied to the codebase.

## 1. Encapsulation🔒📦

- We utilize access modifiers to restrict direct access to object components and bundle data with the methods that operate on that data. This ensures data integrity and prevents external classes from putting an object into an invalid state.
- Entity Data Security: Core attributes within the Entity class (lvl, hp, atk, maxHP) are marked as protected. This allows specific subclasses like Remnant or Mercenary to manipulate their own stats during initialization or combat, while keeping them safe from unrelated utility classes. 🛡️
- Identity Isolation: Properties such as name and description are kept private within specific implementations to ensure unique identity immutability after instantiation. 🧩
- Inventory Management: The Inventory class encapsulates the logic for storing items, exposing only necessary methods to add or remove items, while hiding the underlying data structures for PlayerInventory and AreaInventory. 🎒
 
## 2. Inheritance 🌳📚
#### 🧩 Class Hierarchy Overview
*A hierarchical structure is used to promote code reusability and establish "is-a" relationships. Common logic is defined in parent classes, while specific behaviors are pushed down to child classes.*
Class Hierarchy Overview:

#### Entity System 👤⚔️:
- Entity (Base)
- TowerEntity → Echo / Remnant → SpecificEcho / SpecificRemnant
- Challenger → Mercenary / Knight / Paladin

Entity\
 ├─ TowerEntity\
 │   ├─ Remnant\
 │   │    └─ SpecificRemnant\
 │   └─ Echo\
 │        └─ SpecificEcho\
 └─ Challenger\
      ├─ Mercenary\
      ├─ Knight\
      └─ Paladin\



#### Item System 🗡️🍎:
- Item (Base)
- Consumables
- Weapon → SpecificWeapon (Unique passive holders)

  Item
 ├─ Consumables
 └─ Weapon
       └─ SpecificWeapon (unique passive logic)


  

#### Skill System ✨📜:
- Skill → ActiveSkill / PassiveSkill → [Concrete Implementation]

Skill
 ├─ ActiveSkill
 └─ PassiveSkill
       └─ [Concrete skills with custom effects]





## Location System 🗺️🏞️:
- Location → Floor / Area
*Note: Floor manages a collection of Area objects.*

Location
 ├─ Floor
 │    └─ Contains HashMap<Integer, Area>
 └─ Area






## 3. Polymorphism 🔄

- Polymorphism allows the game engine to treat objects of different classes as objects of a common superclass. This enables dynamic behavior handling at runtime without complex if-else chains.
- State Pattern: The PlayerState interface is implemented by AreaNavigationState, FloorNavigationState, IdleAreaState, and InventoryState. The main game loop interacts with the generic PlayerState interface, allowing the player to switch contexts seamlessly without changing the core engine loop. 🔁
- Combat System: The Battle class is instantiated generically. It can initiate a fight between a Challenger and any TowerEntity. The battle logic calls methods like attack() or useSkill(), and the specific object (Knight vs SpecificRemnant) determines the actual damage calculation or effect execution. ⚔️🔥
- Skill Execution: Both ActiveSkill and PassiveSkill extend Skill. The combat system iterates through a list of Skill objects, invoking their effects. A healing skill and a damage skill are treated uniformly by the invoker, but behave differently upon execution.💥💖 

## 4. Abstraction 🎭📁

- Complex implementation details are hidden behind simple interfaces and abstract classes, exposing only what is necessary for the rest of the system to function.
- Utility Managers: Classes like CutsceneManager, AudioPlayer, and TextTyper act as black boxes. The game logic simply requests "Play Audio" or "Type Text," without needing to understand the underlying timing logic or rendering algorithms. 🎬🔊⌨️
- UI Components: OptionSelect and Format static classes abstract away the complexity of formatting strings and handling user input indices, providing a clean API for the UI layer. 🖥️✨
- Game Flow: The Battle class abstracts the complexity of turn-based logic. The main game loop triggers a battle, and the Battle class handles the minute details of turn order, damage calculation, and win/loss states internally. 🕒⚔️🏆
