package sabreacademy.scrum;

import java.util.Scanner;


class Reader {
	static Scanner scan = null;

	Reader() {
		if (scan == null) {
			if( System.console() != null)
				scan = new Scanner(System.console().reader());
		}
	}

	public boolean hasNext() {
		return scan.hasNext();
	}

	public String next() {
		return scan.next();
	}

	public boolean isInitialized() {
		try {
			return scan != null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}

class Writer {
	public void print(String s) {
		System.out.print(s);
	}
	
	public void println(String x) {
		System.out.println(x);
	}
}

public class EPB {

	public static void main(String[] args) {

		Writer writer = new Writer();

		try {
			
			Reader reader = new Reader();
			boolean isInitialized = !reader.isInitialized();
			if (isInitialized)
				return;
			
			writeMenu(writer);			
			showPrompt(writer);
			while (reader.hasNext()) {
				String str = readImput(reader);
				performAction(writer, str);
			}
		} catch (Exception ex) {
			logException(ex);
		}
	}

	private static void logException(Exception ex) {
		ex.printStackTrace();
	}

	private static void performAction(Writer writer, String str) {
		writer.println(str);
	}

	private static String readImput(Reader reader) {
		String str = reader.next();
		return str;
	}

	private static void showPrompt(Writer writer) {
		writer.print("ePB> ");
	}

	private static void writeMenu(Writer writer) {
		writer.println("Menu: ");
		writer.println("\teXit");
		writer.println("\tAdd item");
		writer.println("\tChange item");
		writer.println("\tRemove item");
		writer.println( "\tHelp item");
	}
}
