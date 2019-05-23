
public class DrinkList {
	private static int drinkNum= 0;
	private String drinkName;
	private int drinkPrice;
	private int drinkStock;
	
	public static int getDrinkNum() {
		return drinkNum;
	}

	public static void setDrinkNum(int drinkNum) {
		DrinkList.drinkNum = drinkNum;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getDrinkPrice() {
		return drinkPrice;
	}

	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}

	public int getDrinkStock() {
		return drinkStock;
	}

	public void setDrinkStock(int drinkStock) {
		this.drinkStock = drinkStock;
	}

	public DrinkList(String drinkName, int drinkPrice, int drinkStock) {
		// TODO Auto-generated constructor stub
		drinkNum++;
		this.drinkName= drinkName;
		this.drinkPrice= drinkPrice;
		this.drinkStock= drinkStock;
		
	}
	
}
