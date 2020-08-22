package com.vastika.uis.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.uis.model.User;
import com.vastika.uis.util.DbUtil;

public class UserDaoImpl implements UserDao {
public static final String INSERT_SQL= "insert into new_table (username, password, email,mobileno,dob)values(?,?,?,?,?)";
public static final String UPDATE_SQL="update new_table set username=?,password=?,mobileno=?,dob=? where id=?";
public static final String DELETE_SQL="delete from new_table where id=?";
public static final String LIST_SQL="select * from new_table";
public static final String GET_BY_ID_SQL="select * from new_table where id=?";



	

	@Override
	public int saveUserInfo(User user) {
	
		int saved=0;
		try (
				Connection con= DbUtil.getConnection();
				PreparedStatement ps= con.prepareStatement(INSERT_SQL);
				){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setLong(4, user.getMobliNo());
			ps.setDate(5, new Date(user.getDob().getTime()));
			saved=ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saved;
	}


	@Override
	public int updateUserInfo(User user) {
		int updated=0;
		try (
				Connection con= DbUtil.getConnection();
				PreparedStatement ps= con.prepareStatement(UPDATE_SQL);
				){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setLong(4, user.getMobliNo());
			ps.setDate(5,(Date) user.getDob());
			ps.setInt(6, user.getId());
			updated=ps.executeUpdate();
			
		}catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace();}
		return updated;
	}
	@Override
	public int deleteUserInfo(int id) {
			int deleted=0;
			try (
					Connection con= DbUtil.getConnection();
					PreparedStatement ps= con.prepareStatement(DELETE_SQL);
					){
				
				ps.setInt(1, id);
				deleted=ps.executeUpdate();
				
				
			}catch (ClassNotFoundException| SQLException e) {
				e.printStackTrace();
			}
			return deleted;
		
	}

	@Override
	public User getUserById(int id) {
		 User user = new User();
		 
		 try (
					Connection con= DbUtil.getConnection();
					PreparedStatement ps= con.prepareStatement(GET_BY_ID_SQL);){
		           	 ps.setInt(1, id);
			 
					ResultSet rs= ps.executeQuery();
				       if(rs.next()) {
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getNString("password"));
						user.setEmail(rs.getString("email"));
						user.setMobliNo(rs.getLong("mobileno"));
						user.setDob(rs.getDate("dob"));
					}
					}catch (ClassNotFoundException| SQLException e) {
						e.printStackTrace();
				}
				return user;
	}  

	@Override
	public List<User> getAllUser() {
		List<User> userList= new ArrayList<>();
		try (
			Connection con= DbUtil.getConnection();
			PreparedStatement ps= con.prepareStatement(LIST_SQL);){
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getNString("password"));
				user.setEmail(rs.getString("email"));
				user.setMobliNo(rs.getLong("mobileno"));
				user.setDob(rs.getDate("dob"));
				userList.add(user);
			}
			}catch (ClassNotFoundException| SQLException e) {
				e.printStackTrace();
		}
		return userList;
	}

}
