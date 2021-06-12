package com.hust.address.gendata;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


public class GenProvince {
	 public void test1() {
			try {

				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://ec2-54-224-194-214.compute-1.amazonaws.com:5432/dam6id0cbjikdc?user=dtgmwctdgppvpi&password=10708d94667e51f185e91e67af37946652c782343fd4552318c009b27ea2b6a5&sslmode=require";
				Connection connection = DriverManager.getConnection(url);
				
				Statement start = connection.createStatement();
				System.out.println("connected...");
				Scanner input = new Scanner(new File("d:/Database/sscm/app/data/tinh.txt"));
				System.out.println("opened");
				do {
					String province_id = input.next();
					String province_name = input.nextLine();
					String sql = "insert into province (province_id, province_name)" + " values ('" + province_id.trim() + "','" + province_name.trim() + "')";
					start.executeUpdate(sql);
				} while(input.hasNext());
				
				input.close();
				
				connection.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    }
	 public static void main(String [] args) {
		 GenProvince gen = new GenProvince();
		 gen.test1();
	 }
}
