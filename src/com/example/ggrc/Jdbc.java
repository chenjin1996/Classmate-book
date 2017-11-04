package com.example.ggrc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Jdbc {
	String name;
	String address;
	String phone;
	String wechat ;
	String email;
	String qq  ;
	String signature ;
	Connection con;
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false";
	String user = "root";
	String password = "wuxiaohui";
	
	public Jdbc(String name,String address ,String phone,String wechat,String email,String qq,String signature) {
		this.name=name;
		this.address=address;
		this.phone=phone;
		this.wechat=wechat;
		this.email=email;
		this.qq=qq;
		this.signature=signature;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = (Connection) DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(!con.isClosed())
			    System.out.println("Succeeded connecting to the Database!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Jdbc(String name) {
		this.name=name;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = (Connection) DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(!con.isClosed())
			    System.out.println("Succeeded connecting to the Database!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Jdbc() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = (Connection) DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(!con.isClosed())
			    System.out.println("Succeeded connecting to the Database!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public int insert() {
    	
    	 int i = 0;
    	 String sql = "insert into studentInformation (name,address,phone,wechat,email,qq,signature) values(?,?,?,?,?,?,?)";
    	 PreparedStatement pstmt;
    	    try {
    	        pstmt = (PreparedStatement) con.prepareStatement(sql);
    	        pstmt.setString(1, name);
    	        pstmt.setString(2, address);
    	        pstmt.setString(3, phone);
    	        pstmt.setString(4, wechat);
    	        pstmt.setString(5,email);
    	        pstmt.setString(6, qq);
    	        pstmt.setString(7, signature);
    	        i = pstmt.executeUpdate();
    	        pstmt.close();
    	        con.close();
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    return i;
    	
    }
    public int update(String sql){
    	int i = 0;
        //String sql = "update students set Age='" + student.getAge() + "' where Name='" + student.getName() + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public int delete(String sql) {
        int i = 0;
        //String sql = "delete from students where Name='" + name + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public String[][] select(String sql) {
    	
			String[][] st= new String[10][7];
			Statement statement;
			try {
				statement = (Statement) con.createStatement();
				//3.ResultSet类，用来存放获取的结果集！！
	            ResultSet rs = statement.executeQuery(sql);
	            int i=1;
	            int j=0;
	            int k=0;
	            while(rs.next()){
	                
	                st[j][k++]=rs.getString(i++);
	                System.out.println(i);
	                if(k==6) {
	                	j++;
	                	k=0;
	                }
	                
	                
	              
	            }
	            rs.close();
	            con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return st;
			
            
    }
		
}