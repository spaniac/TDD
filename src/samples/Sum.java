package samples;

public class Sum implements Expression {
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = this.augend.reduce(bank, to).amount + this.addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    public Expression times(int multiplier){
        return new Sum(this.augend.times(multiplier),
                this.addend.times(multiplier));
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, this.addend);
    }
}