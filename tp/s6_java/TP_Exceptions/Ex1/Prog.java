package Ex1;

import java.util.Scanner;

public class Prog {
	public static void main(String[] args) throws ErrConst {
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<3;i++) {
			System.out.println("donner un numéro :");
			int number = sc.nextInt();
			EntNet e1 = new EntNet(number);
			System.out.println("valeur valide :"+e1.getN());
		}
	}
}
