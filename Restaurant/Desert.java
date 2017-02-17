package Restaurant;

import java.util.Random;

import Restaurant.Restaurant.SectionType;

public class Desert extends Meals{

	public Desert(String name, int weight ) {
		super(SectionType.DESERT, name, 4, weight);
	}
	
	
	@Override
	public void setWeight(int weight) {
		if(weight>=200 && weight<=300){
			this.weight=weight;
		}
		else{
			this.weight=new Random().nextInt(201)+100;
		}
		
	}

}
