package Ex2;
import java.util.Scanner;

public class Programme {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Donner une valeur");
		int valeur = sc.nextInt();
		try{
			EntNet e = new EntNet(valeur);
			System.out.println("Donner deux valeur pour effectuer diff�rentes op�rations :");
			System.out.println("Valeur 1:");
			int a = sc.nextInt();
			System.out.println("Valeur 2:");
			int b = sc.nextInt();
			System.out.println("Somme: "+e.Somme(a,b));
			System.out.println("diff�rence: "+e.Difference(a,b));
			System.out.println("Produit: "+e.Produit(a,b));
		}
		catch(ErrConst ec) {
			System.out.println("erreur d�clench� par la valeur("+ec.n+"): valeur n�gative !!\"");
		}catch(ErrNat en) {
			//e.printStackTrace();
			System.out.println("erreur d�clench� par les valeurs("+en.a+" et "+en.b+"):"+en.message);
		}
		
		
		try{
			EntNet e = new EntNet(valeur);
			System.out.println("\n \n Donner deux valeur pour effectuer diff�rentes op�rations :");
			System.out.println("Valeur 1:");
			int a = sc.nextInt();
			System.out.println("Valeur 2:");
			int b = sc.nextInt();
			System.out.println("Somme: "+e.Somme(a,b));
			System.out.println("diff�rence: "+e.Difference(a,b));
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
