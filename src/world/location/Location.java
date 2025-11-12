package world.location;

public abstract class Location {
    
    private String name;
    private String description;
    private String lockID;
    private boolean isLocked;

    public Location(String name, String description, String lock_id){
        this.name = name;
        this.description = description;
        this.lockID = lock_id;
        if(lock_id == "nolock"){
            this.isLocked = false;
        }
        else this.isLocked = true;
    }

    public void unlock(){
        isLocked = false;
    }


    public String getLockID(){return lockID;}
    public boolean isLocked(){return isLocked;}
    public String getName(){return name;}
    public String getDescription(){return description;}

}
