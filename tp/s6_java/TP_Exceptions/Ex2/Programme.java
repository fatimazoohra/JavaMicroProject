package Ex2;
import java.util.Scanner;

public class Programme {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Donner une valeur");
		int valeur = sc.nextInt();
		try{
			EntNet e = new EntNet(valeur);
			System.out.println("Donner deux valeur pour effectuer différentes opérations :");
			System.out.println("Valeur 1:");
			int a = sc.nextInt();
			System.out.println("Valeur 2:");
			int b = sc.nextInt();
			System.out.println("Somme: "+e.Somme(a,b));
			System.out.println("différence: "+e.Difference(a,b));
			System.out.println("Produit: "+e.Produit(a,b));
		}
		catch(ErrConst ec) {
			System.out.println("erreur déclenché par la valeur("+ec.n+"): valeur négative !!\"");
		}catch(ErrNat en) {
			//e.printStackTrace();
			System.out.println("erreur déclenché par les valeurs("+en.a+" et "+en.b+"):"+en.message);
		}
		
		
		try{
			EntNet e = new EntNet(valeur);
			System.out.println("\n \n Donner deux valeur pour effectuer différentes opérations :");
			System.out.println("Valeur 1:");
			int a = sc.nextInt();
			System.out.println("Valeur 2:");
			int b = sc.nextInt();
			System.out.println("Somme: "+e.Somme(a,b));
			System.out.println("différence: "+e.Difference(a,b));
			System.out.println("Produit: "+e.Produit(a,b));
		}
		catch(ErrConst ec) {
			ec.printStackTrace();
			System.out.println(ec);
		}catch(ErrNat en) {
			//e.printStackTrace();
			System.out.println(en);
		}
	}
}
