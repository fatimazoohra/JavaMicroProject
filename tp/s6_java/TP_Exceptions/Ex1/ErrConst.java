package Ex1;

public class ErrConst extends Exception{
	public ErrConst(){
		System.out.println("la valeur est n�gative");
		System.exit(-1);
	};
}
