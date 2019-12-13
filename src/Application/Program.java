package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entities.Product;
import Service.CalculationService;

public class Program {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String path="C:\\temp\\Product.txt";
		
		List<Product> list=new ArrayList<>();
		try(BufferedReader br=new BufferedReader(new FileReader(path))){
			String line=br.readLine();
			while(line!=null) {
				String[] vect=line.split(",");
				list.add(new Product(vect[0],Double.parseDouble(vect[1])));
				line=br.readLine();
			}
			
			Product x=CalculationService.max(list);
			
			System.out.println("Most Expensive is: " + x);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
	public static <T extends Comparable<?super T>> T maxi(List<? extends T> list) {
		T max=list.get(0);
		for(T item: list) {
			if(item.compareTo(max)>0) {
				max=item;
			}
		}
		return max ;
	}
}
