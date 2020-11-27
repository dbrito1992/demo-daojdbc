package aplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=============== Teste 1 FindById =====================");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);
		
		System.out.println("=============== Teste 2 FindByDepartment =====================");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=============== Teste 3 FindAll =====================");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=============== Teste 4 Insert =====================");
		Seller newSeller = new Seller(null, "Diego", "teste@teste.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted id = " + newSeller.getId());
		
		System.out.println("=============== Teste 5 Update =====================");
		seller = sellerDao.findById(2);
		seller.setName("Diego Pontes");
		seller.setEmail("teste2@teste.com");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("=============== Teste 5 Update =====================");
		System.out.print("Enter Id for delete: ");
		int id = sc.nextInt();
		sellerDao.deleteByid(id);
		System.out.println("Delete Completed");
		
		sc.close();
	}

}
