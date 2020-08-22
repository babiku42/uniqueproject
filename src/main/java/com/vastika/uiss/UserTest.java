package com.vastika.uiss;

import java.util.Scanner;

import com.vastika.uis.controller.UserController;

public class UserTest {

	public static void main(String[] args) {
UserController controller = new UserController();
Scanner input= new Scanner(System.in);
String decision="";
do {
	
	System.out.println("Enter which db you want to perform? save|update|delete|get|list|");
	String choice= input.next();
	switch (choice) {
	case "save":
	controller.saveUserInfo(input);
	break;
	case "update":
	controller.updateUserInfo(input);
	case "delete":
	controller.deleteUserInfo(input);
	
	break;
	case "get":
	controller.getUserById(input);;
	break;
	case "list":
	controller.getAllUser();;
	break;
	default:
		System.out.println("sorry");
}

System.out.println("Press Y/y to continue");
decision= input.next();
}while(decision.equalsIgnoreCase("Y"));

System.out.println("Thank you for coding!!!!!!!!");
}
}