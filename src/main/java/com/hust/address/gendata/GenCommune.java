package com.hust.address.gendata;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class GenCommune {
	public void test1() {
		try {

			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://ec2-54-224-194-214.compute-1.amazonaws.com:5432/dam6id0cbjikdc?user=dtgmwctdgppvpi&password=10708d94667e51f185e91e67af37946652c782343fd4552318c009b27ea2b6a5&sslmode=require";
			Connection connection = DriverManager.getConnection(url);
			Statement start = connection.createStatement();
			System.out.println("connected...");
			Scanner input = new Scanner(new File("d:/Database/sscm/app/data/xa.txt"));
			System.out.println("opened");
			ResultSet rs = start.executeQuery("SELECT * FROM district");
			while (rs.next()) {
				System.out.println(rs.getString("district_id") + "\t" + rs.getString("district_name"));
			}
			
			do {
				String district_id = input.next().trim();
				String commune_id = input.next().trim();
				String commune_name = input.nextLine().trim();
				String sql = "insert into commune (commune_id , district_id , commune_name ) values ('" + commune_id + "','" + district_id + "','" + commune_name + "')";
				start.executeUpdate(sql);
			} while(input.hasNext());
			
			input.close();
			
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
	public static void main(String [] args) {
		GenCommune gen = new GenCommune();
		gen.test1();
 }
}
