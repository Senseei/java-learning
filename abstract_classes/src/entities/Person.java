package entities;

public abstract class Person {
    private String name;
    private Double anualIncome;

    protected Person(String name, Double anualIncome) {
        this.name = name;
        this.anualIncome = anualIncome;
    }

    public String getName() {
        return name;
    }

    public Double getAnualIncome() {
        return anualIncome;
    }

    public abstract Double tax();
}
