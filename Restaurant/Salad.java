package Restaurant;

import java.util.Random;

import Restaurant.Restaurant.SectionType;

public class Salad extends Meals implements IVegan{

	public Salad(String name, int weight ) {
		super(SectionType.SALAD, name, 5, weight);
	}

	@Override
	public void setWeight(int weight) {
		if(weight>=300 && weight<=600){
			this.weight=weight;
		}
		else{
			this.weight=new Random().nextInt(301)+300;
		}
		
	}

}
