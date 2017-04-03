package TrickOrTreatMultithreading;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        System.out.println( "Trick-Or-Treating begins" );
        House house = new House();

        CandyServer candyServer = new CandyServer(house);
        CustomerGenerator cg = new CustomerGenerator(house);

        Thread thcandyServer = new Thread(candyServer);
        Thread thcg = new Thread(cg);
        thcg.start();
        thcandyServer.start();
    }
}
