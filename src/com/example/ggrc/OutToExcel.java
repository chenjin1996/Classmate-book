package com.example.ggrc;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

//poi包、数据库未配置



public class OutToExcel {
	
	//设置Excel导出地址
	public final static String outputFile="Studentbooks.xls";
    public final static String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false";  ////////
    public final static String user="root";
    public final static String password="wuxiaohui";
    
    
	public void toexcel(){
		// TODO Auto-generated method stub
		//Class.forName("com.mysql.jdbc.Driver");
		  try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn=(Connection) DriverManager.getConnection(url, user, password);
	            Statement stat = (Statement) conn.createStatement();
	            ResultSet resultSet = stat.executeQuery("select * from studentInformation;");      //选择表
	            HSSFWorkbook workbook=new HSSFWorkbook();
	            HSSFSheet sheet=workbook.createSheet("countryDB");   //修改
	            HSSFRow row = sheet.createRow((short)0);
	            HSSFCell cell=null;
	            cell=row.createCell((short)0);
	            cell.setCellValue("name");
	            cell=row.createCell((short)1);
	            cell.setCellValue("address");
	            cell=row.createCell((short)2);
	            cell.setCellValue("phone");
	            cell=row.createCell((short)3);
	            cell.setCellValue("wechat");
	            cell=row.createCell((short)4);
	            cell.setCellValue("email");
	            cell=row.createCell((short)5);
	            cell.setCellValue("qq");
	            cell=row.createCell((short)6);
	            cell.setCellValue("signature");
	            
	            int i=1;
	            
	            while(resultSet.next())
	            {
	                row=sheet.createRow(i);
	                cell=row.createCell(0);
	                cell.setCellValue(resultSet.getString("name"));          
	                cell=row.createCell(1);
	                cell.setCellValue(resultSet.getString("address"));
	                cell=row.createCell(2);
	                cell.setCellValue(resultSet.getString("phone"));
	                cell=row.createCell(3);
	                cell.setCellValue(resultSet.getString("wechat"));
	                cell=row.createCell(4);
	                cell.setCellValue(resultSet.getString("email"));
	                cell=row.createCell(5);
	                cell.setCellValue(resultSet.getString("qq"));
	                cell=row.createCell(6);
	                cell.setCellValue(resultSet.getString("signature"));
	                
	                
	                i++;
	             }
	            FileOutputStream FOut = new FileOutputStream(outputFile);
	            workbook.write(FOut);
	            FOut.flush();
	            FOut.close();
	        } 
		  catch (Exception e) 
		  {
	            e.printStackTrace();
	       }
	    
		
	}

}


