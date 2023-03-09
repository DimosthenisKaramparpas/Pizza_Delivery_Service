package pizzaorder;
import java.util.Random;

public enum DeliveryDistance {
	A(5), B(10), C(15);
	private int value;
	private static DeliveryDistance deliveryDistance;
	
	private DeliveryDistance(int value) {
		this.value = value;
	}
	
	public static DeliveryDistance getRandomDistance() {
		Random rand = new Random();
		int circle = rand.nextInt(3);
		if (circle==0)
			deliveryDistance = A;
		if (circle==1)
			deliveryDistance = B;
		if (circle==2)
			deliveryDistance = C;
		return deliveryDistance;
	}
	
	public int getTime() {
		return deliveryDistance.value;
	}
}
