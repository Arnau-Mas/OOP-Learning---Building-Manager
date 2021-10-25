public class Edifici{
	protected String nom;
	protected int numPlantes;
	protected int superficie;
	
	public Edifici(String nom, int numPlantes, int superficie) {
		this.nom = nom;
		this.numPlantes = numPlantes;
		this.superficie = superficie;
	}
	
	public String getName() {
		return nom;
	}
	
	public int getNumPlantes() {
		return numPlantes;
	}
	
	public int getSuperficie() {
		return superficie;
	}
	
	public void setName(String nom) {
		this.nom = nom;
	}
	
	public void setNumPlantes(int numPlantes) {
		this.numPlantes = numPlantes;
	}
	
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public String netejar() {
		double temps = superficie/5;
		double tempsPerPlanta = 0;
		if(numPlantes>1) {
			tempsPerPlanta = numPlantes*0.5;
		}
		double tempsTotal = temps+tempsPerPlanta;
		double preuMensual = tempsTotal*30;
		
		return "Aquest edifici s'ha tardat en netejar "+tempsTotal+" minuts i el preu mensual ascendeix a: "+preuMensual+"€";
	}
	
	public int calcularCostVigilancia() {
		int numVigilants = superficie/1000;
		if(numVigilants == 0) {
			numVigilants = 1;
		}
		int costVigilants = numVigilants*1300;
		return costVigilants;
	}
	
	public String toString() {
		return "** Nom de l'edifici:"+getName()+" / Número de plantes:"+getNumPlantes()+" / Superficie:"+getSuperficie()+" / "+netejar()+" / El cost de la vigilància és de "+calcularCostVigilancia()+"€";
	}
}