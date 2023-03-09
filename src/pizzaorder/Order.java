package pizzaorder;
import java.util.ArrayList;

public class Order {
	private int orderID=0;
	
	ArrayList<Ingredient> ingredients = Ingredient.getRandomIngredients();
	DeliveryDistance deliverydistance = DeliveryDistance.getRandomDistance();
	int time = deliverydistance.getTime();
	
	
	public int getPrice() {
		int orderCost=5;
		for (int i=0;i<ingredients.size();i++) {
			orderCost+= ingredients.get(i).getPrice();
		}
	return orderCost;
	}
	public int getTime() {
		return time;
	}
}
