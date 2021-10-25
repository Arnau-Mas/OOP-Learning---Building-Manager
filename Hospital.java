public class Hospital extends Edifici{
	
	private int racions = 3;
	
	public Hospital(String nom, int numPlantes, int superficie) {
		super(nom, numPlantes, superficie);
	}
	
	public int getRacions() {
		return racions;
	}
	
	public void setRacions(int racions) {
		this.racions = racions;
	}
	
	public String repartirDinar() {
		return "S'estan repartint "+racions+".";
	}
	
	public String toString() {
		return super.toString()+". El número de racions és: "+getRacions()+" i "+repartirDinar(); //aqui sobreescrivim el toString però aprofitant el toString del pare (super.toString());
		
	}
}