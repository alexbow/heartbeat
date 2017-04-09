/**
 * Created by Alex on 4/8/2017.
 */
public class HeartBeatDriver {

    private Database database;
    private Database databaseTwo;
    private Integer currentDatabase;

    public void HeartBeatDriver(){
        this.database = new Database(true);
        this.databaseTwo = new Database(false);
        this.currentDatabase = 1;

        System.out.println("Database one is currently: " + database.isActive());
        System.out.println("Database two is currently: " + databaseTwo.isActive());

        switchActiveDatabase();
        System.out.println("Database one is currently: " + database.isActive());
        System.out.println("Database two is currently: " + databaseTwo.isActive());

        switchActiveDatabase();
        System.out.println("Database one is currently: " + database.isActive());
        System.out.println("Database two is currently: " + databaseTwo.isActive());
    }

    public static void main(String args[]){
        HeartBeatDriver heartBeatDriver = new HeartBeatDriver();
        heartBeatDriver.HeartBeatDriver();
    }

    public void switchActiveDatabase(){
        if(this.currentDatabase == 1){
            this.currentDatabase = 2;
            this.database.setActive(false);
            this.databaseTwo.setActive(true);
        }
        else{
            this.currentDatabase = 1;
            this.database.setActive(true);
            this.databaseTwo.setActive(false);
        }
    }
}
