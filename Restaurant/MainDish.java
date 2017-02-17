package Restaurant;

import java.util.Random;

import Restaurant.Restaurant.SectionType;

public class MainDish extends Meals implements IMurta{

	public MainDish(String name, int weight ) {
		super(SectionType.MAIN_DISH, name, 9, weight);
	}
	
	
	@Override
	public void setWeight(int weight) {
		if(weight>=400 && weight<=800){
			this.weight=weight;
		}
		else{
			this.weight=new Random().nextInt(401)+400;
		}
		
	}

}
