package Restaurant;

import java.util.HashMap;

import Clients.Clients;

public class Waiter implements Comparable<Waiter> {
	
	private String name;
	private double tipMoney;
	private Restaurant restaurant;
	private HashMap<Clients, Integer> clients;
	
	public Waiter(String name) {
		this.name = name;
		this.tipMoney=0;
		this.clients= new HashMap();
	}
	
	public void orderMenu(Clients cl, Menu ord) {
		if(!this.clients.containsKey(cl)){
			this.clients.put(cl, ord.getPrice());
			return;
		}
		else{
			this.clients.put(cl, this.clients.get(cl)+ord.getPrice());
		}
		
		
	}

	public int getBill(Clients cl) {
		if(this.clients.get(cl)!=null){
			return this.clients.get(cl);
		}
		else{
			return 0;
		}
	}
	public void getPayment(double tip, Clients cl) {
		this.tipMoney+=tip;
		this.restaurant.recieveBill(this.getBill(cl));
		this.clients.remove(cl);
		
	}
	public void setRestaurant(Restaurant r) {
		this.restaurant=r;
		
	}
	
	

	@Override
	public String toString() {
		return "Waiter - " + name + ", tipMoney - " + tipMoney + "]";
	}

	@Override
	public int compareTo(Waiter o) {
		
		return (int) (o.tipMoney-this.tipMoney);
	}




	
	

}
