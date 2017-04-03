package TrickOrTreatMultithreading;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 4/2/17.
 */
public class CustomerGenerator implements Runnable {
    House house;

    public CustomerGenerator(House house)
    {
        this.house = house;
    }

    public void run()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }

        for (int index = 0; index < 1001 ; index++) {

        }
        while(true)
        {
            Customer customer = new Customer(house);
            customer.setInTime(new Date());
            Thread thcustomer = new Thread(customer);
            customer.setName("Customer Thread "+thcustomer.getId());
            thcustomer.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*3));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
}
