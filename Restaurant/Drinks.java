package Restaurant;

import Restaurant.Restaurant.MenuType;
import Restaurant.Restaurant.SectionType;

public class Drinks extends Menu {

	public Drinks(SectionType section, String name, int price) {
		super(MenuType.DRINK, section, name, price);
	}

}
