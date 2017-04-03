package TrickOrTreatMultithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 4/2/17.
 */
public class House {
    int houseQueue;
    List<Customer> listCustomer;

    public House()
    {
        houseQueue = 11;
        listCustomer = new LinkedList<Customer>();
    }

    public void serveCandy()
    {
        Customer customer;
        synchronized (listCustomer)
        {

            while(listCustomer.size()==0)
            {
                System.out.println("Riley watches TV.");
                try
                {
                    listCustomer.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            System.out.println("Riley answers door.");
            customer = (Customer)((LinkedList<?>)listCustomer).poll();
        }
        long duration= 3; // time to serve candy to one person
        try
        {
            System.out.println("Riley serving candy to Customer : "+customer.getName());
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Completed Serving candy to Customer : "+customer.getName() + " in "+duration+ " seconds.");
    }

    public void add(Customer customer)
    {
        System.out.println("Customer : "+customer.getName()+ " entering the house at "+customer.getInTime());

        synchronized (listCustomer)
        {
            if(listCustomer.size() == houseQueue)
            {
                System.out.println("!!!Too long of wait for candy for customer "+customer.getName());
                System.out.println("Customer "+customer.getName()+"Exists...");
                return ;
            }

            ((LinkedList<Customer>)listCustomer).offer(customer);
            System.out.println("Customer : "+customer.getName()+ " got the candy.");

            if(listCustomer.size()==1)
                listCustomer.notify();
        }
    }
}
