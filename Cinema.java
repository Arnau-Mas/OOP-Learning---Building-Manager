public class Cinema extends Edifici{
	public Cinema(String nom, int numPlantes, int superficie) {
		super(nom, numPlantes, superficie);
	}
	
	public int calcularCostVigilancia() {
		int numVigilants = superficie/3000;
		if(numVigilants == 0) {
			numVigilants = 1;
		}
		int costVigilants = numVigilants*1300;
		return costVigilants;
	}
	
	public String projectarSessio(int numAssistents, double preuEntrada) {
		String frase = "Error en el n�mero d'assistents. L'aforament m�xim �s de 146 persones.";
		if(numAssistents>146) {
			frase="Error en el n�mero d'assistents. L'aforament m�xim �s de 146 persones.";
		}else {
			double recaptacio = numAssistents*preuEntrada;
			frase = "La recaptaci� ha estat de "+recaptacio+"�";
		}
		return frase;
	}
	
	public String toString() {
		return super.toString()+" i "+projectarSessio(20, 15); //Aqui poso els parametres d'exemple per� no s� si �s el que demanaves
	}
}