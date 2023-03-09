package pizzeria;
import pizzaorder.*;
import java.util.LinkedList;

public class PizzaProfit extends PizzaStore{
	
	public PizzaProfit() {
		super();
	}
	
	public void run() {
		while(running) {
			if(!orderList.isEmpty()) {
				Order currentOrder = this.findBigger(orderList);
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
	public Order findBigger(LinkedList<Order> orderList){
		int price=0;
		int index=0;
		for(int i=0; i<orderList.size();i++) {
			if(orderList.get(i).getPrice()>price) {
				price=orderList.get(i).getPrice();
				index=i;
			}
		}
		
		return orderList.get(index);
	}
}