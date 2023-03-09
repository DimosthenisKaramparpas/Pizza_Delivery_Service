package pizzeria;
import pizzaorder.*;
import java.util.LinkedList;

abstract class PizzaStore implements Runnable{
	protected LinkedList<Order> orderList;
    public int profit=0;
    protected double timeTranslation = 16;
    //Each simulated minute is 0.06 ms of real time
    protected boolean running=true;

    public PizzaStore() {
        this.orderList = new LinkedList<Order>();
    }

    public abstract void run();

    public void stop() {
        running = false;
    }

    public void addOrder(Order order) {
        this.orderList.add(order);
    }
}

