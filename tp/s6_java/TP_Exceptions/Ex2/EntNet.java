package Ex2;
public class EntNet {
	private int n;
	public EntNet(int n) throws ErrConst{
		if (n<0) throw new ErrConst(n);
		this.n = n;
	}
	public static int Somme(int a, int b) throws ErrNat{
		//System.out.println(Integer.MAX_VALUE);
		int som = a+b;
		if (som > Integer.MAX_VALUE || som< 0) throw new ErrSom("somme non representable",a,b);
		return som; 
	}
	public static int Difference(int a, int b) throws ErrNat{
		int diff = a-b;
		if (diff > Integer.MAX_VALUE || diff< 0) throw new ErrDiff("différence non representable", a,b);
			return diff; 
	}
	public static int Produit(int a, int b) throws ErrNat{
		int p = a*b;
		if (p > Integer.MAX_VALUE || p< 0) throw new ErrProd("produit non représentable",a,b);
		//if (p > Integer.MAX_VALUE ) throw new ErrDepasse("limite dépassée",a,b);
		return p; 
	}
	public int getN() {
		return this.n;
	}
}
