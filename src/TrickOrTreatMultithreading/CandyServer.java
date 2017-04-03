package TrickOrTreatMultithreading;

/**
 * Created by student on 4/2/17.
 */
public class CandyServer implements Runnable{
    House house;

    public CandyServer(House house)
    {
        this.house = house;
    }

    public void run()
    {

        System.out.println("CandyServer started..");
        while(true)
        {
            house.serveCandy();
        }
    }
}
