import java.util.ArrayList;
import java.util.Scanner;

public class App{
	
	static ArrayList<Edifici> ddbb = new ArrayList<Edifici>(); //o crear 3 arrays de cada tipus d'edifici
	
	public static void main(String[] args) {
		welcomeText();
		menuGestioEdificis();
	}
	
	//Intro
	static void welcomeText() {
		System.out.println("Benvingut al sistema de gestió d'Edificis d'IT Academy. Aqui podràs gestionar els següents edificis: (Hotel / Hospital / Cinema).");
	}
	
	static void menuGestioEdificis() {
		Scanner input = new Scanner(System.in);
		int funcioEscollida;
		do {
			System.out.println("\nSiusplau. Escriu el número de la funció vols dur a terme:\n1.Donar d'alta un edifici\n2.Veure un edifici\n3.Eliminar un edifici\n0.Sortir del programa");
			funcioEscollida = input.nextInt();
			switch(funcioEscollida) {
			case 0: System.out.println("Gràcies per utilitzar el nostre sistema. A reveure.");
			break;
			case 1: donarAltaEdifici(demanaTipusEdifici());
			break;
			case 2: veureEdifici(demanaString("nom")); 
			break;
			case 3: donarBaixaEdifici(demanaString("nom")); 
			break;
			default: System.out.println("Aquest tipus d'edifici no està en el nostre sistema");
			}
		}while(funcioEscollida!=0);
	}
	
	//Funcionalidades del programa
	static void donarAltaEdifici(int tipusEdifici) {
		String nom = demanaString("nom");
		int indexEdifici = trobarEdifici(nom);
		while(indexEdifici!=-1) {
			System.out.println("Aquest nom ja existeix. Siusplau, introdueix un altre nom.");
			nom = demanaString("nom");
			indexEdifici = trobarEdifici(nom);
		}
		switch(tipusEdifici) {
		case 1: ddbb.add(new Hotel(nom, demanaInt("número de plantes"), demanaInt("superficie"), demanaInt("número d'habitacions per planta")));
		break;
		case 2: ddbb.add(new Hospital(nom, demanaInt("número de plantes"), demanaInt("superficie")));
		break;
		case 3: ddbb.add(new Cinema(nom, demanaInt("número de plantes"), demanaInt("superficie")));
		break;
		default: System.out.println("Ha hagut un error i no s'ha pogut donar d'alta l'edifici. Torna a intentar-ho.");
		}
		
		System.out.println("L'edifici s'ha creat correctament.");
	}
	
	static void veureEdifici(String nomEdifici) {
			int indexEdifici = trobarEdifici(nomEdifici);
			if(indexEdifici==-1) {
				System.out.println("No s'ha trobat aquest edifici en la base de dades.");
			}else {
				System.out.println(ddbb.get(indexEdifici).toString());
		}
	}

	static void donarBaixaEdifici(String nomEdifici) {
		int indexEdifici = trobarEdifici(nomEdifici);
		if(indexEdifici==-1) {
			System.out.println("No s'ha trobat aquest edifici en la base de dades.");
		}else {
			ddbb.remove(indexEdifici);
			System.out.println("L'edifici s'ha eliminat correctament.");
		}
	}
	
	//Herramientas pedida datos
	static String demanaString(String paraula) {
		Scanner input = new Scanner(System.in);
		System.out.println("Introdueix el/la "+paraula+" de l'edifici:");
		String paraulaIntroduida = input.nextLine();
		return paraulaIntroduida;
	}
	
	static int demanaInt(String paraula) {
		Scanner input = new Scanner(System.in);
		System.out.println("Introdueix el/la "+paraula+" de l'edifici:");
		int intIntroduit = input.nextInt();
		return intIntroduit;
	}
	
	static int demanaTipusEdifici() {
		Scanner input = new Scanner(System.in);
		System.out.println("Siusplau, escriu el número del tipus d'edifici vols donar d'alta: 1.Hotel / 2.Hospital / 3.Cinema.");
		int tipusEdifici = input.nextInt();
		return tipusEdifici;
	}
	
	//Herramientas programa
	static int trobarEdifici(String nom) {
		int edificiTrobat = -1;
		int i = 0;
		if(ddbb.size()!=0) {
			while(edificiTrobat==-1 && i<ddbb.size()) {
				if(nom.equals(ddbb.get(i).getName())) {
					edificiTrobat = i;
				}
				i++;
			}
		}
		return edificiTrobat;
	}
}