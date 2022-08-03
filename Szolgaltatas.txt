public class Szolgaltatas implements CSVMentheto{
    
    private String megnevezes;
    private int ar;
    
    public Szolgaltatas (String megnevezes, int ar){
        this.megnevezes = megnevezes;
        this.ar = ar;
    }
	
	public String csvFormatum(String elvalaszto){
		return this.megnevezes+elvalaszto+this.ar+elvalaszto+"Szolgaltatas\n";
	}

}