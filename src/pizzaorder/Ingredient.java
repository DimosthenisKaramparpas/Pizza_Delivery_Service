package pizzaorder;
import java.util.Random;
import java.util.ArrayList;
import java.util.EnumSet;
	public enum Ingredient {
		CHEESE, ONIONS, 
		PINEAPPLE, PEPPERONI, 
		CHICKEN, BEEF, SAUSAGE;
	
	private int price;
	Ingredient() {
		price = 2;
	}
	public int getPrice() {
		return price;
	}
	public static ArrayList<Ingredient> getRandomIngredients() {
		Random rand = new Random();
		int circle = rand.nextInt(7);//To choose the number of ingredients
		
		EnumSet<Ingredient> set = EnumSet.allOf(Ingredient.class);
		ArrayList<Ingredient> selected = new ArrayList<>();
		
		for(int i = 0; i<circle; i++) {
			int index = rand.nextInt(set.size());
			Ingredient selectedIngredient = (Ingredient) set.toArray()[index];
			selected.add(selectedIngredient);
			set.remove(selectedIngredient);
		}
		return selected;
	}
}
