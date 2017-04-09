/**
 * Created by Alex on 4/8/2017.
 */
public class Database{
    private boolean isActive;

    public Database(boolean isActive){
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
