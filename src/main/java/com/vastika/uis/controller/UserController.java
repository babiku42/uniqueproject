package com.vastika.uis.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServieImpl;

public class UserController {
UserService userService= new UserServieImpl();
public void saveUserInfo(Scanner input) {
	User user= getUserData(input);
	
	 int saved= userService.saveUserInfo(user);
	 if (saved>=1) {
		 System.out.println("user info is saved into database successfully");
	 }
	 else { 
		 System.out.println("error in database");
	 }
	
	
	
}
public void updateUserInfo(Scanner input) {
	User user = getUserData(input);
	System.out.println(("enter id"));
	int id=input.nextInt();
	
	user.setId(id);
	 int updated= userService.saveUserInfo(user);
	 if (updated>=1) {
		 System.out.println("user info is updated into database successfully");
	 }
	 else { 
		 System.out.println("error in database");
}
}
public void getUserById(Scanner input) {
	System.out.println("ENter your id");
	int id= input.nextInt();
	User user= userService.getUserById(id);
System.out.println("User id is"+ user.getId());
System.out.println("Username is"+ user.getPassword());
System.out.println("Email is"+user.getEmail());
System.out.println("mobile number is"+ user.getMobliNo());
System.out.println("date of birth is"+ user.getDob());
}
public void getAllUser() {
	List<User> userlist= userService.getAllUser();
	for(User user:userlist) {
		System.out.println("User id is"+ user.getId());
		System.out.println("Username is"+ user.getPassword());
		System.out.println("Email is"+user.getEmail());
		System.out.println("mobile number is"+ user.getMobliNo());
		System.out.println("date of birth is"+ user.getDob());
		System.out.println("===============================================");
		
	}
}

private User getUserData(Scanner input) {
	User user= new User();
 
	 System.out.println("Enter the username");
	 String username= input.next();
	 System.out.println();
	 System.out.println("Enter the Password");
	 String password= input.next();
	 System.out.println("Enter the email");
	 String email= input.next();
	 
	 System.out.println("ENter the MoblieNo");
	 Long mobileno=input.nextLong();
	 System.out.println("Enter dob");
	 String dob= input.next();
	 
	 user.setUsername(username);
	 user.setPassword(password);
	 user.setEmail(email);
	 user.setMobliNo(mobileno);
	 SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	 try {
		 Date d= sdf.parse(dob);
		 user.setDob(d);
		 
	 }
	 catch (ParseException e) {
		 e.printStackTrace();
	 }
	return user;
}
public void deleteUserInfo(Scanner input) {
	
	System.out.println("enter the id");
	int id= input.nextInt();
	int deleted= userService.deleteUserInfo(id);
	if(deleted>=1) {
		System.out.println("The database is deleted sucessfully");
	}else {
		System.out.println("database error");
	}
	
	
	
}
}
