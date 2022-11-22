package bazaPodataka;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class BazaHandler {
	public static List<String> ucitajVreme() throws IOException {
		List<String> list = new ArrayList<String>();
		FileInputStream inputStream = new FileInputStream(
				"C:\\Users\\Marketa\\Desktop\\aerodromProjekat\\vremePolaska.txt");
		String everything;
		try {
			everything = IOUtils.toString(inputStream);
		} finally {
			inputStream.close();
		}
		list = Arrays.asList(everything.split(","));

		return list;
	}

	public static List<String> ucitajDestinacije() throws IOException {
		List<String> list = new ArrayList<String>();
		FileInputStream inputStream = new FileInputStream(
				"C:\\Users\\Marketa\\Desktop\\aerodromProjekat\\destinacije.txt");
		String everything;
		try {
			everything = IOUtils.toString(inputStream);
		} finally {
			inputStream.close();
		}
		list = Arrays.asList(everything.split(";"));

		return list;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(ucitajDestinacije());
		System.out.println(ucitajVreme());
	}
}
