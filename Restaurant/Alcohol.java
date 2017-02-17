package Restaurant;

import Restaurant.Restaurant.SectionType;

public class Alcohol extends Drinks implements IMurta {

	public Alcohol( String name) {
		super(SectionType.ALCOHOL, name, 4);
	}

}
