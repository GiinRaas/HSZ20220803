package sajatInterface;

public class FoprgramSzolgatatasKapcsolat{
	
	public static void main(String[] args){
		
		Szolgaltatas szolgObj1 = new Szolgaltatas("Konyveles", 130000);
		Szolgaltatas szolgObj2 = new Szolgaltatas("Berszamfejtes", 75000);
		Szolgaltatas szolgObj3 = new Szolgaltatas("Adobevallas", 50000);
		Szolgaltatas szolgObj4 = new Szolgaltatas("Cegalapitas", 60000);
		
		Kapcsolat kapcsolatObj1  = new Kapcsolat("Alfa Bt","1201 Bp." , "alfabt@gmail.com" , "+361...", new Szolgaltatas[] {szolgObj1, szolgObj2});		
		Kapcsolat kapcsolatObj2 = new Kapcsolat("Beta RT.", "2225 Ullo", "betart@gmail.com", "+3629...", new Szolgaltatas[] {szolgObj2});		
		Kapcsolat kapcsolatObj3 = new Kapcsolat("Gamma Kft." , "6000 Kecskemet" , "gamma@gmail.com" , "+36...", new Szolgaltatas[] {szolgObj2, szolgObj3, szolgObj4});
		
		Kapcsolat[] kapcsolatok = new Kapcsolat[] {kapcsolatObj1,kapcsolatObj2,kapcsolatObj3};
		Szolgaltatas[]  szolgaltatasok = new Szolgaltatas[] {szolgObj1, szolgObj2, szolgObj3, szolgObj4};
		/*
		CSVKiiro csv = null;
		
		try {
			csv = new CSVKiiro("teljesmentes.csv");
			for (Kapcsolat kapcsolat : kapcsolatok){
					csv.fajbaIras(kapcsolat);
				for (Szolgaltatas szolgaltatas : kapcsolat.getSzolgaltatasok()){
					csv.fajbaIras(szolgaltatas);
				}
			}
			
		}
		catch(IOException e){
			System.out.println("I/O hiba --> "+e.getMessage());
		}
		finally{
			if (csv != null){
				try{
					csv.close();
				}
				catch (IOException e) {
					System.out.println("I/O hiba -->"+e.getMessage());
				}
			}
		}*/
		
		// try with resources --> a try fejreszeben kell deklaralni eroforrasokat, ezeket automat lezarja ha kilepunk a try-bol --> megsporoljuk a finallyt 
		//teljes mentes 
		try (CSVKiiro csv = new CSVKiiro("teljesmentes.csv")){
			for (Kapcsolat kapcsolat : kapcsolatok){
					csv.fajbaIras(kapcsolat);
				for (Szolgaltatas szolgaltatas : kapcsolat.getSzolgaltatasok()){
					csv.fajbaIras(szolgaltatas);
				}
			}
		}
		catch (IOException e){
			System.out.println("I/O hiba --> "+e.getMessage());
		}
		//kulon lementve csak a kapcsolatok
		try (CSVKiiro csv = new CSVKiiro("kapcsolat.csv")){
			for (Kapcsolat kapcsolat : kapcsolatok){
				csv.fajbaIras(kapcsolat);
			}
			catch (IOException e){
				System.out.println("I/O hiba --> "+e.getMessage());
			}
		}
		//kulon lementve csak a szolgaltatasok
		try (CSVKiiro csv = new CSVKiiro("kapcsolat.csv")){
			for (Szolgaltatas szolgaltatas : szolgaltatasok){
				csv.fajbaIras(szolgaltatas);
			}
			
		}
		catch (IOException e){
				System.out.println("I/O hiba --> "+e.getMessage());
			}
			
		// kapcsolatok es szolgaltatasok kulon fajba mentve, egy try blokkol belul:
		try (CSVKiiro csv = new CSVKiiro("kapcsolat.csv");
				CSVKiiro csv2 = new CSVKiiro("szolgaltatas.csv")){
					for (Kapcsolat kapcsolat : kapcsolatok){
					csv.fajbaIras(kapcsolat);
					}
					or (Szolgaltatas szolgaltatas : szolgaltatasok){
				csv2.fajbaIras(szolgaltatas);
				}
				}
				catch(IOException e){
					System.out.println("I/O hiba --> "+e.getMessage());
				}
		
	}
	
}