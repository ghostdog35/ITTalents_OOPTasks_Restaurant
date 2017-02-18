package Demo;

import java.util.ArrayList;
import java.util.Random;

import Clients.Clients;
import Clients.Mutra;
import Clients.Student;
import Clients.Vegan;
import Restaurant.Restaurant;

public class Demo {
	public static void main(String[] args) {
		
		Restaurant pesho = new Restaurant("Pri pesho talanta", "Sofia");
		pesho.showInfo();
		ArrayList<Clients> clients = new ArrayList<>();
		
		for (int i = 0; i < 15; i++) {
			int r = new Random().nextInt(100)+1;
			if(r<=20){
				clients.add(new Vegan("Vegan Petrov"));
				continue;
			}
			if(r<=50){
				clients.add(new Student("Student Ivanov"));
				continue;
			}
			clients.add(new Mutra("Pesho Kartofa"));
		}
		System.out.println(clients);
		
		for (Clients client : clients) {
			for (int i = 0; i < 3; i++){
				client.makeOrder(pesho);
			}
			client.payBill(client.askBill());
		}
		
		pesho.showInfo();
		pesho.printWaiters();
		pesho.printMenuSorted();
	}
}
