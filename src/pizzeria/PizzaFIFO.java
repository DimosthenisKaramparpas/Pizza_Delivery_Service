package pizzeria;
import pizzaorder.*;

public class PizzaFIFO extends PizzaStore{
	public PizzaFIFO() {
		super();
	}
	
	public void run() {
		while(running) {
			if(!orderList.isEmpty()) {
				Order currentOrder = orderList.peek();
				double deliveryTime = currentOrder.getTime()*2;
				
				try {
					Thread.sleep((long)(deliveryTime * timeTranslation));
					profit+=currentOrder.getPrice();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				orderList.pop();
			}
		}
	}
}
