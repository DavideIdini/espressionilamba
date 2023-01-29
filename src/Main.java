import java.util.function.*;

interface Operation{
    public double doIt(double a, double b);
}

public class Main {
    public static void main(String[] args) {
        Operation sum = ( x,  y) -> {
            double result = 0.0;
            result = x+y;
            return result;
        };
        Operation diff = ( x,  y) -> x-y;
        System.out.println(sum.doIt(90.0, 19.9));
        System.out.println(diff.doIt(9, 4));
        doOperation(10.0, 2.0, diff);
        Predicate<String> startsWhithA = (s)->{
            return (s.charAt(0) == 'a') ? true : false;
        };
        System.out.println(startsWhithA.test("ealbero"));
        Predicate<Integer> minOf100 = (z) ->{
          return  (z<100) ? true : false;
        };
        System.out.println(minOf100.test(999));
        Function<Integer, Integer> makeDouble = (m) -> {
            return m*2;
        };
        System.out.println(makeDouble.apply(10));
        Function<Integer, Integer> makeTriple = (n)->{
          return n*3;
        };
        useOperation(10,makeTriple);
        useOperation(10, makeDouble);
        Function<String [], String > longestString = (s) -> {
            String tmp = s[0];
            for(int i = 0; i<s.length ; i++)
                if(tmp.length()<s[i].length())
                    tmp = s[i];
            return tmp;
        };
        System.out.println(longestString.apply(new String[]{"ciao", "come", "stai","precipitevolissimevolmente"}));

    }
    public static void doOperation(double a, double b, Operation op){
        System.out.println(op.doIt(a, b));
    }
    public static void useOperation(int n, Function s){
        System.out.println(s.apply(n));
    }
}