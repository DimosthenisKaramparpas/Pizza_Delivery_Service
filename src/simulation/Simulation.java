package simulation;
import	java.util.concurrent.Executors;	
import javax.swing.JOptionPane;
import	java.util.concurrent.ExecutorService;
import java.util.Timer;
import java.util.TimerTask;
import pizzeria.*;
import pizzaorder.*;

public class Simulation {
	
	private int time;
	private int orders;
	
	public Simulation(int time, int orders){
		this.time=time;
		this.orders=orders;
		start();
	}
	
	public void start() {
		ExecutorService exec = Executors.newCachedThreadPool();
        // Create threads for each store
        PizzaFIFO pizzaFIFO = new PizzaFIFO();
        PizzaProfit pizzaProfit = new PizzaProfit();
        PizzaRandom pizzaRandom = new PizzaRandom();

        // Start the threads
        exec.execute(pizzaFIFO);
        exec.execute(pizzaRandom);
        exec.execute(pizzaProfit);
        
        Timer timer = new Timer();
        TimerTask timertask = new TimerTask() {
        	int count = 0;
        	@Override
        	public void run() {
        		for(int i=0;i<orders;i++) {
        		Order newOrder = new Order();
        		pizzaFIFO.addOrder(newOrder);
        		pizzaProfit.addOrder(newOrder);
        		pizzaRandom.addOrder(newOrder);
        		}
        		count++;
        		if(count==time) {
        			JOptionPane.showMessageDialog(null,"Hours : "+time+"\n"+"Orders per Hour : "+orders+"\n"+"Profit of FIFO is : " + pizzaFIFO.profit + "\n" + "Profit of Profit is : " + pizzaProfit.profit + "\n"+"Profit of Random is : " + pizzaRandom.profit,"Profits",1);
        			System.out.println("Profit of FIFO");
        			System.out.println(pizzaFIFO.profit);
        			System.out.println("Profit of Profit");
        			System.out.println(pizzaProfit.profit);
        			System.out.println("Profit of Random");
        			System.out.println(pizzaRandom.profit);
        			exec.shutdown();
        		}
        	
        	}
        };
        timer.schedule(timertask, 0, 1000);
}
}

