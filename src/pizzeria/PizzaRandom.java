package pizzeria;
import pizzaorder.*;
import java.util.LinkedList;
import java.util.Random;

public class PizzaRandom extends PizzaStore{

	public void run() {
		while(running) {
			if(!orderList.isEmpty()) {
				Order currentOrder = this.findRandom(orderList);
				double deliveryTime = currentOrder.getTime()*2;
				
				try {
					Thread.sleep((long)(deliveryTime * timeTranslation));
					profit+=currentOrder.getPrice();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				orderList.remove(currentOrder);
			}
		}
	}
	public Order findRandom(LinkedList<Order> orderList){
		int index=0;
		Random rand = new Random();
		index = rand.nextInt(orderList.size());
		return orderList.get(index);
	}
}