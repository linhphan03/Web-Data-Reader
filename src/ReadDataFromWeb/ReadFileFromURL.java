package ReadDataFromWeb;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ReadFileFromURL {
	/* index.html: default page in directory on web servers
	 * default.html / home.html
	 * Can access data from file on web with URL (unique address for file on web)
	 * Enter URL in Web browser, Web server sends data to browser -> data */
	
	public static void main(String[]args) {
	    System.out.println("Working Directory = " + System.getProperty("user.dir"));

		System.out.print("Enter an URL: ");
		String URLString = new Scanner(System.in).nextLine();
		//Create URL object
		try {
			//http:// is required for URL class
			URL url = new URL(URLString);
			//count character
			int countCharacter = 0;
			/* openStream(): take data at specified URL
			 * Then, read bytes from InputStream returned by openStream()
			 * TODO: open input stream to create Scanner and read bytes from Input Stream */
			
			Scanner sc = new Scanner(url.openStream());
			File file = new File("ReadData.txt");
			PrintWriter newFile = new PrintWriter(file);
			
			while (sc.hasNext()) {
				String line = sc.nextLine();
				countCharacter += line.length();
				newFile.print(line);
			}
			System.out.println(newFile);
			System.out.printf("The file size is " + countCharacter + " characters");
		}
		//Invalid URL, esp invalid / missing protocol
		catch (MalformedURLException ex) {
			System.out.println("Invalid URL");
		}
		
		//failed input / output
		catch (IOException ex) {
			System.out.println("I/O errors: no such file");
		}
		
		/* Crawl HTML file
		 * Test 1: https://gist.github.com/apipemc/6047552 
		 * Test 2: https://stackoverflow.com/questions/2778312/how-does-java-url-openstream-work
		 * Test 3: https://www.facebook.com/thuylinhphan.2212/
		 */
	}
}
