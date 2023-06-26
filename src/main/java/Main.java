import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("0.00");
	
	public static void main(String[] args) {
		
		// Euro zu Dollar
		System.out.println("Wie viel Euro wollen sie zu Dollar umwandeln?");
		double input = Double.parseDouble(sc.nextLine()); 
		Conversion conv = readJson();
		
		String output = df.format(input)+"€ => "+df.format(input*conv.toDollar)+"$";
		System.out.println(output);
		
		
		
	}
	
	public static Conversion readJson() {
		// Der ObjectMapper ist dazu da, Daten aus einer json-Datei zu lesen und in ein Objekt umzuwandeln
		ObjectMapper mapper = new ObjectMapper();
		Conversion conv = null;
	
		try {
			// Der Mapper erstellt ein Objekt von Conversion, liest die Daten aus der JSON Datei und schmeist sie ins Objekt.
			// conv = mapper.readValue(new URL("https://mein-api-anbieter.com/api/data.json"), Conversion.class);
			conv = mapper.readValue(new File("src/main/resources/data.json"), Conversion.class);
			System.out.println(conv);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return conv;
	}

}
