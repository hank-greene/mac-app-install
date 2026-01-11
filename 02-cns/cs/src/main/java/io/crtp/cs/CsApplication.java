package io.crtp.cs;

import java.beans.BeanProperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.math.BigDecimal;

@SpringBootApplication
public class CsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("inspect the beans");

			Connection conn = null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // Explicitly register the driver
				conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/",
					"sblrndb",
					"reacher-landman-calvin"
				);
				System.out.println("It worked!");
			} catch (ClassNotFoundException e) {
				System.out.println("Driver class not found: " + e.getMessage());
			} catch (SQLException e) {
				System.out.println("SQL error: " + e.getMessage());
			}

			try {
				Statement stmt = conn.createStatement(); 
				String sql = "DROP DATABASE IF EXISTS ACCOUNTING25";
				stmt.executeUpdate(sql);
				System.out.println("transactions table dropped.");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Transactions table did not exist.");
			}

			try {
				Statement stmt = conn.createStatement();
				String sql = "CREATE DATABASE ACCOUNTING25";
				stmt.executeUpdate(sql);
				System.out.println("Created transactions table.");
			} catch (Exception ex) {
				//ex.printStackTrace();
				System.out.println("Error creating transactions table.");
			}

			try {
				Statement stmt = conn.createStatement();
				String sql = "USE ACCOUNTING25";
				stmt.executeUpdate(sql);
				sql = "CREATE TABLE TRANSACTIONS " +
					"(id INTEGER not NULL AUTO_INCREMENT, " +
					" date VARCHAR(10), " + 
					" account VARCHAR(15), " + 
					" amount DECIMAL(9,4), " + 
					" PRIMARY KEY ( id ))"; 
				stmt.executeUpdate(sql);
				System.out.println("Created transactions table.");
			} catch (Exception ex) {
				//ex.printStackTrace();
				System.out.println(ex.toString());
				System.out.println("Error creating transactions table.");
			}

			try {

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			//String[] beanNames = ctx.getBeanDefinitionNames();
			//Arrays.sort(beanNames);
			//for (String beanName : beanNames ) {
			//	System.out.println(beanName);
			//}

			//String trxInsert = "INSERT INTO transactions (date, account, amount) VALUES (?, ?, ?)";
			//PreparedStatement pst = conn.prepareStatement(trxInsert);

			try {

				CSVReader reader = new CSVReader(new FileReader("my-expenses-10-eoy-LAST.csv"));

				String[] record = null;

				while ((record = reader.readNext()) != null) {

					try {
						System.out.println(record[0]+" "+record[1]+" "+record[2]+" "+record[3]+" "+record[4]+" "+record[5]+" "+record[6]);

						System.out.println(record[2]);

						String trxInsert = "INSERT INTO transactions (date, account, amount) VALUES (?, ?, ?)";
						PreparedStatement pst = conn.prepareStatement(trxInsert);


						if (new String(record[2]).isEmpty()) {
							record[2] = "0";
						}

						pst.setString(1,record[0]);
						pst.setString(2,record[1]);
						pst.setBigDecimal(3,new BigDecimal(record[2]));
						pst.executeUpdate();
						pst.close();
					} catch(Exception x){
						System.out.println(x.toString());
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		};
		
	}

}
