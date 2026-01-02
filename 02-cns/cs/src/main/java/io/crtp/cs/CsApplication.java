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

@SpringBootApplication
public class CsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("inspect the beans");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames ) {
				System.out.println(beanName);
			}

			try {

				CSVReader reader = new CSVReader(new FileReader("my-expenses-10-eoy-work.csv"));

				String[] record = null;

				while ((record = reader.readNext()) != null) {
					System.out.println(record[0]+" "+record[1]+" "+record[2]+" "+record[3]+" "+record[4]+" "+record[5]+" "+record[6]);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		};
	}
}
