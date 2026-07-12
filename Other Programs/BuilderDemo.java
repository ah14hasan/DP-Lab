// Product
class Sandwich {
    private final String bread;
    private final String protein;
    private final boolean cheese;

    public Sandwich(String bread, String protein, boolean cheese) {
        this.bread = bread;
        this.protein = protein;
        this.cheese = cheese;
    }

    public void describe() {
        System.out.println("Sandwich: " + bread + ", " + protein + (cheese ? ", with cheese" : ""));
    }
}

// Builder
class SandwichBuilder {
    private String bread;
    private String protein;
    private boolean cheese;

    public SandwichBuilder setBread(String bread) 
    { this.bread = bread; return this; }
    public SandwichBuilder setProtein(String protein) 
    { this.protein = protein; return this; }
    public SandwichBuilder addCheese() 
    { this.cheese = true; return this; }

    public Sandwich build() 
    { return new Sandwich(bread, protein, cheese); } // assembles final product
}

// Client
public class BuilderDemo {
    public static void main(String[] args) {
        Sandwich sandwich = new SandwichBuilder()
                .setBread("Whole wheat")
                .setProtein("Turkey")
                .addCheese()
                .build(); // step-by-step construction, only what's needed

        sandwich.describe();
    }
}
