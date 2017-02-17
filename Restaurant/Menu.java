package Restaurant;

import Restaurant.Restaurant.MenuType;
import Restaurant.Restaurant.SectionType;

public abstract class Menu {
	
	private MenuType type;
	private SectionType section;
	private String name;
	private int price;
	
	public Menu(MenuType type, SectionType section, String name, int price) {
		this.type = type;
		this.section = section;
		this.name = name;
		this.price = price;
	}

	public MenuType getType() {
		return type;
	}

	public SectionType getSection() {
		return section;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + " - " + price + " lv.";
	}
	
	
	

}
