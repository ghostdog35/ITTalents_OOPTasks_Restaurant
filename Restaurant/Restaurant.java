package Restaurant;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import Clients.Clients;
import Clients.Mutra;
import Clients.Vegan;

public class Restaurant {
	public enum MenuType {
		MEAL, DRINK
	}
	public enum SectionType {
		SALAD, MAIN_DISH, DESERT, ALCOHOL, NONALCOHOL
	}
	
	private String name;
	private String address;
	private int capital;
	private ArrayList<Waiter> waiters;
	private HashMap<MenuType, HashMap<SectionType, ArrayList<Menu> >> menu;
	
	public Restaurant(String name, String address) {
		this.name = name;
		this.address = address;
		this.capital=1000;
		this.waiters= new ArrayList();
		this.menu=new HashMap();
		for (int i = 0; i < 20; i++) {
			this.addMeal(new Salad("Caesar salad", 0));
			this.addMeal(new MainDish("Beef Stroganoff", 0));
			this.addMeal(new Desert("Creme brulee", 0));
			this.addMeal(new Alcohol("Jack Daniels"));
			this.addMeal(new Alcohol("Cardhu"));
			this.addMeal(new NonAlcohol("Coca Cola"));
			this.addMeal(new NonAlcohol("Fanta Orange"));
		}
		this.addWaiter(new Waiter("Ali Mustafa"));
		this.addWaiter(new Waiter("Saho Mustaka"));
		this.addWaiter(new Waiter("Gosho Perchema"));
		this.addWaiter(new Waiter("Pacho Ohluva"));
		this.addWaiter(new Waiter("Stefcho Ochilata"));
		
		
	}
	
	public void addWaiter(Waiter w){
		if(w!=null){
			this.waiters.add(w);
			w.setRestaurant(this);
		}
	}
	
	public void addMeal(Menu m){
		if(!menu.containsKey(m.getType())){
			menu.put(m.getType(), new HashMap<>());
		}
		if(!menu.get(m.getType()).containsKey(m.getSection())){
			menu.get(m.getType()).put(m.getSection(), new ArrayList<>());
		}
		menu.get(m.getType()).get(m.getSection()).add(m);
	}
	
	public Waiter getRandomWaiter() {
		return this.waiters.get(new Random().nextInt(this.waiters.size()));
	}
	public Menu getRandomMenu(Clients cl) {
		Menu temp=null;
		if(cl instanceof Mutra){
			if(this.menu.get(MenuType.DRINK).get(SectionType.ALCOHOL).isEmpty()&&this.menu.get(MenuType.MEAL).get(SectionType.MAIN_DISH).isEmpty()){
				System.out.println("There's nothing for you to order today");
				return null;
			}
			if(new Random().nextBoolean()){
				if(!this.menu.get(MenuType.DRINK).get(SectionType.ALCOHOL).isEmpty()){
					temp = this.menu.get(MenuType.DRINK).get(SectionType.ALCOHOL).get(0);
					this.menu.get(MenuType.DRINK).get(SectionType.ALCOHOL).remove(0);
					return temp;
				}
			}
			if(!this.menu.get(MenuType.MEAL).get(SectionType.MAIN_DISH).isEmpty()){
				temp = this.menu.get(MenuType.MEAL).get(SectionType.MAIN_DISH).get(0);
				this.menu.get(MenuType.MEAL).get(SectionType.MAIN_DISH).remove(0);
				return temp;
			}
			else{
				return null;
			}
		}
		if(cl instanceof Vegan){
			if(this.menu.get(MenuType.DRINK).get(SectionType.NONALCOHOL).isEmpty()&&this.menu.get(MenuType.MEAL).get(SectionType.SALAD).isEmpty()){
				System.out.println("There's nothing for you to order today");
				return null;
			}
			if(new Random().nextBoolean()){
				if(!this.menu.get(MenuType.DRINK).get(SectionType.NONALCOHOL).isEmpty()){
					temp = this.menu.get(MenuType.DRINK).get(SectionType.NONALCOHOL).get(0);
					this.menu.get(MenuType.DRINK).get(SectionType.NONALCOHOL).remove(0);
					return temp;
				}
			}
			if(!this.menu.get(MenuType.MEAL).get(SectionType.SALAD).isEmpty()){
				temp = this.menu.get(MenuType.MEAL).get(SectionType.SALAD).get(0);
				this.menu.get(MenuType.MEAL).get(SectionType.SALAD).remove(0);
				return temp;
			}
			else{
				return null;
			}
		}
		while(temp==null){
			MenuType m1= MenuType.values()[new Random().nextInt(MenuType.values().length)];
			SectionType s1= SectionType.values()[new Random().nextInt(SectionType.values().length)];
			if(this.menu.get(m1).containsKey(s1) && !this.menu.get(m1).get(s1).isEmpty()){
				temp=this.menu.get(m1).get(s1).get(0);
				this.menu.get(m1).get(s1).remove(0);
				return temp;
			}
		}
		return null;
	}
	public void showInfo(){
		System.out.println("---------Restaurant "+this.name+" -----------");
		for (Entry <MenuType, HashMap<SectionType, ArrayList<Menu>>> type : menu.entrySet()) {
			System.out.println("------ "+type.getKey()+"'S ---------");
			for (Entry<SectionType, ArrayList<Menu>> section : type.getValue().entrySet()) {
				System.out.println("------ "+section.getKey()+"'S ---------");
				System.out.println(section.getValue());
			}
		}
		System.out.println("Capital "+this.capital);
	}

	public void recieveBill(Integer in) {
		this.capital+=in;
	}
	public void printWaiters(){
		Collections.sort(this.waiters);
		System.out.println(waiters);
	}
	
	public void printSortedMeals(){
		
	}
	public void printMenuSorted(){
		System.out.println("---------Restaurant "+this.name+" -----------");
		for (Entry <MenuType, HashMap<SectionType, ArrayList<Menu>>> type : menu.entrySet()) {
			System.out.println("------ "+type.getKey()+"'S ---------");
			SortedSet<Map.Entry<SectionType, Integer>> sorted = new TreeSet<>(new Comparator<Map.Entry<SectionType, Integer>>(){
				@Override
				public int compare(Entry<SectionType, Integer> o1, Entry<SectionType, Integer> o2) {
					if(o1.getValue()==o2.getValue()){
						return 1;
					}
					return o2.getValue()-o1.getValue();
				}
			});
			SortedMap<SectionType, Integer> tempMap = new TreeMap<>();
			for (Entry<SectionType, ArrayList<Menu>> section : type.getValue().entrySet()) {
				tempMap.put(section.getKey(), section.getValue().size());
			}
			sorted.addAll(tempMap.entrySet());
			for (Entry<SectionType, Integer> entry : sorted) {
				System.out.println("    - "+entry.getKey()+" - "+entry.getValue()+" portions");
			}
		}
	}

}
