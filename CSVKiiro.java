package sajatInterface;

import java.io.*;

public class CSVKiiro implements Closeable{
	
	private FileWriter fw;
	
	public CSVKiiro(String fajlnev) throws IOException{
		this.fw = new FileWriter(fajlnev,Charset.forname("UTF-8"),false);
		System.out.println("FileWriter peldanyositva");
	}
	
	public void fajlbaIras(CSVMentheto csvObjektum) throws IOException{
		fw.write(csvObjektum.csvFormatum(";"));
		System.out.println("Adat fajlba irva");
	}
	
	public void close() throws IOException{
		
		fw.close();
		System.out.println("Eroforras lezarva");
	}
	
}