package Clients;

import java.util.Random;

import Restaurant.Menu;
import Restaurant.Restaurant;
import Restaurant.Waiter;

public abstract class Clients {
	
	private String name;
	private int money;
	private Waiter waiter; 
	
	public Clients(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	
	public int getMoney() {
		return money;
	}


	public void makeOrder(Restaurant r){
		if(this.waiter==null){
			this.waiter=r.getRandomWaiter();
		}
		if(this.money<2){
			System.out.println("Not enough money to order anything");
		}
		Menu temp = r.getRandomMenu(this);
		if(temp!= null && temp.getPrice()<this.money*0.9){
			this.waiter.orderMenu(this, temp);
			this.money-=temp.getPrice();
		}
		else{
			System.out.println("Not enough money for this order");
		}
	}
	public int askBill(){
		return this.waiter.getBill(this);
	}
	
	public void payBill(int b){
		double tip=0;
		if(new Random().nextInt(100)+1<81){
			tip=b*(new Random().nextInt(6)+5)/100;
			this.money-=tip;
		}
		this.waiter.getPayment(tip, this);
	}


	@Override
	public String toString() {
		return name + " - money=" + money;
	}
	
	
	
	

}
