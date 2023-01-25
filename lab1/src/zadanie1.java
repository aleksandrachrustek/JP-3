import java.math.BigInteger;

public class zadanie1 {

    public static void main(String[] args) {
        if (args[0].matches("\\d+")) {
            BigInteger n = new BigInteger(args[0]);
            System.out.println(liczba(n));
        } else {
            System.out.println("Podana liczba nie jest poprawna!");
        }
    }

    public static BigInteger silnia(BigInteger x) {
        if (x.compareTo(BigInteger.TWO) < 0) return BigInteger.ONE;
        else return x.multiply(silnia(x.subtract(BigInteger.ONE)));

    }

    public static BigInteger liczba(BigInteger n) {
        BigInteger suma = new BigInteger(String.valueOf(-1));
        BigInteger j = BigInteger.valueOf(3);
        for (;j.compareTo(n)<=0; j=j.add(BigInteger.valueOf(1))) {
            BigInteger s = silnia(j.subtract(BigInteger.TWO));
            suma = suma.add(s.subtract(j.multiply(s.divide(j))));
        }
        return suma;
    }
}
