
package Ex2;

public class ErrNat  extends Exception {
	int a;
	int b;
	String message;
	public ErrNat( String message, int a, int b) {
		this.message = (message);
		this.a = a;
		this.b = b;
	}
}
