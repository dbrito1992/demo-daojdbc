package aplication;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Computador");
		
		Seller seller = new Seller(1, "Bob", new Date(), 1000.0, obj);
		System.out.println(seller);

	}

}
