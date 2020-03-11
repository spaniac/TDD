package samples;

import java.util.Hashtable;

public class Bank {
    private Hashtable<Pair, Integer> rates = new Hashtable<>();

    public void addRate(String from, String to, int rate){
        this.rates.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) return 1;
        return rates.get(new Pair(from, to));
//        return (from.equals("CHF") && to.equals("USD"))
//                ? 2
//                : 1;
    }

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }
}