package Restaurant;

import Restaurant.Restaurant.MenuType;
import Restaurant.Restaurant.SectionType;

public abstract class Meals extends Menu {
	
	protected int weight;

	public Meals(SectionType section, String name, int price, int weight) {
		super(MenuType.MEAL, section, name, price);
		this.setWeight(weight);
		
	}
	public abstract void setWeight(int weight);

}
