import java.math.BigInteger;

public class zadanie2 {

    public static void main(String[] args) {
        BigInteger n = new BigInteger(args[0]);
        if(n.compareTo(BigInteger.ZERO)<0) System.out.println("Podana liczba nie jest naturalna!");
        System.out.println("n0= "+n);
        for(int i =1; i<1001; i++){
            n=kolejna(n);
            System.out.println("n"+i+"= "+n);
            if (kolejna(n).equals(BigInteger.ONE)) break;
        }
    }
    public static BigInteger kolejna(BigInteger n){
        if(n.testBit(0)) {
            n=(n.multiply(BigInteger.valueOf(3)));
            n=n.add(BigInteger.ONE);
        }
        else n=n.divide(BigInteger.TWO);
        return n;
    }
}