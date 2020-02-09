package Ex1;
import java.util.Scanner;

public class EntNet {
	private int n;
	public EntNet(int n) throws ErrConst {
		if (n<0) throw new ErrConst();
		this.n = n;
	}
	public int getN() {
		return this.n;
	}
	
}

