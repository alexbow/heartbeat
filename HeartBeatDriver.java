import java.util.Random;

/**
 * Created by Alex on 4/8/2017.
 */
public class HeartBeatDriver {

    private Database database;
    private Database databaseTwo;
    private Integer currentDatabase;

    //constructor builds two databases and starts the simulation
    public void HeartBeatDriver(){
        this.database = new Database(true);
        this.databaseTwo = new Database(true);
        this.currentDatabase = 1;

        System.out.println("Database one is currently: " + database.isActive());
        System.out.println("Database two is currently: " + databaseTwo.isActive());
        runSimulation();
    }

    //runs a simulation of the databases going out and coming back up switching to the safe one.
    public void runSimulation(){
        int randInt = randInt(1, 3);
        int count = 20;
        while(count != 0){//randInt != 0){
            if(randInt == 1){
                randInt = randInt(1, 3);
                if(this.database.isActive() == true && this.currentDatabase == 1){
                    this.database.setActive(false);
                    this.currentDatabase = 2;
                    System.out.println("Database one has gone down! Switching to database two");
                }
                if(this.database.isActive() == true && this.currentDatabase == 2){
                    this.databaseTwo.setActive(false);
                    this.currentDatabase = 1;
                    System.out.println("Database two has gone down! Switching to database one");
                }
                else{
                    if(this.database.isActive() == false){
                        this.database.setActive(true);
                        System.out.println("Database one has come back online!");
                    }
                    else{
                        this.databaseTwo.setActive(true);
                        System.out.println("Database two has come back online!");
                    }
                }
            }
            else{
                randInt--;
                count--;
            }
        }
    }

    //main create instance of our class
    public static void main(String args[]){
        HeartBeatDriver heartBeatDriver = new HeartBeatDriver();
        heartBeatDriver.HeartBeatDriver();
    }

    public void switchActiveDatabase(){
        if(this.currentDatabase == 1){
            this.currentDatabase = 2;
        }
        else{
            this.currentDatabase = 1;
        }
    }

    //generates a random number between the value of min and max
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
