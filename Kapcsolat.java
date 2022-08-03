package sajatInterface;

public class Kapcsolat implements CSVMentheto{

	private String nev;
	private String cim;
	private String email;
	private String telefon;

	private Szolgaltatas[] szolgaltatasok;   

	// Kapcsolat es Szolgaltatas kozott nem hierarchikus, csak asszociacios kapcsolat
	//minden kapcsolat rendelkezik egy taroloval az altala igenybe vett szolgaltatasokrol

	public Kapcsolat (String nev, String cim, String email, String telefon, Szolgaltatas[] szolgaltatasok){

		this.nev=nev;
		this.cim = cim;
		this.email = email;
		this.telefon = telefon;
		this.szolgaltatasok = szolgaltatasok;
	}
	
	public Szolgaltatas[](){
		return szolgaltatasok;
	}
	
	public String csvFormatum(String elvalaszto){
		return this.nev+elvalaszto+this.cim+elvalaszto+this.email+elvalaszto+this.telefon+elvalaszto+"Kapcsolat\n";
	}
	


}