package samples;

//팩토리 메서드 패턴
public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Expression times(int multiplier) {
        return new Money(this.amount * multiplier, currency);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(this.currency, to);
        return new Money(this.amount / rate, to);
    }

    public String currency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return this.amount == money.amount && this.currency().equals(money.currency());
    }
}