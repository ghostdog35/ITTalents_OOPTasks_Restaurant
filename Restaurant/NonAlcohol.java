package Restaurant;

import Restaurant.Restaurant.SectionType;

public class NonAlcohol extends Drinks implements IVegan {

	public NonAlcohol( String name) {
		super(SectionType.NONALCOHOL, name, 2);
	}

}
