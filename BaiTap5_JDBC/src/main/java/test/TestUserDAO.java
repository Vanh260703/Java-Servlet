package test;

import java.util.ArrayList;

import dao.userDAO;
import model.user;

public class TestUserDAO {
	public static void main(String[] args) {
		/*
		 * test insert user user1 = new user("viet", "1234", "Anh Viet");
		 * 
		 * userDAO.getInstance().insert(user1); System.out.println(user1.toString());
		 */

		/*
		 * test delete user user1 = new user("vanh", "123456", "Viet Anh");
		 * userDAO.getInstance().delete(user1); System.out.println(user1.toString());
		 */

		user user1 = new user("viet", "123456", "Anh Viet");
		userDAO.getInstance().update(user1);
		System.out.println(user1.toString());

		// test selectAll
		ArrayList<user> list = userDAO.getInstance().selectAll();
		for (user user : list) {
			System.out.println(user.toString());
		}

		System.out.println("----------------------");

		// test selectById
		user find = new user();
		find.setUserName("piu");
		user user2 = userDAO.getInstance().selectById(find);
		System.out.println(user2.toString());

		System.out.println("--------------");

		// test selectByCondition
		ArrayList<user> list2 = userDAO.getInstance().selectByCondition("ho_va_ten = 'Giang'");
		for (user user : list2) {
			System.out.println(user.toString());
		}
	}
}
