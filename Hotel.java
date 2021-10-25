public class Hotel extends Edifici{
	
	private int numHabitacionsPlanta;
			
	public Hotel(String nom, int numPlantes, int superficie, int numHabitacionsPlanta) {
		super(nom, numPlantes, superficie);
		this.numHabitacionsPlanta = numHabitacionsPlanta;
	}
	
	public int getNumHabitacionsPlanta() {
		return numHabitacionsPlanta;
	}
	
	public int calcularCostVigilancia() {
		int costVigilants = super.calcularCostVigilancia();
		int numVigilants = costVigilants/1300;
		costVigilants = costVigilants+(numVigilants*500);
		
		return costVigilants;
	}
	
	public String netejar() {
		int personalNecessari = numHabitacionsPlanta*20;
		System.out.println("S�n necess�ries "+personalNecessari+" persones.");
		int souTotal = personalNecessari*1000;
		return "S�n necess�ries "+personalNecessari+" persones per netejar i el cost total per pagar els seus sous �s de "+souTotal+"�.";
	}
	
	public String toString() {
		return "** Nom de l'edifici:"+getName()+" / N�mero de plantes:"+getNumPlantes()+" / Superficie:"+getSuperficie()+" / N�mero d'habitacions/planta: "+getNumHabitacionsPlanta()+"/ "+netejar()+" / El cost de la vigil�ncia �s de: "+calcularCostVigilancia()+"�";
	}
}