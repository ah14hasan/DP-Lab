// Element
interface Item {
    void accept(Visitor visitor);
}

// ConcreteElement
class Book implements Item {
    public void accept(Visitor visitor) 
    { visitor.visit(this); } // hands itself to the visitor
}
class Electronics implements Item {
    public void accept(Visitor visitor) 
    { visitor.visit(this); }
}

// Visitor
interface Visitor {
    void visit(Book book);
    void visit(Electronics electronics);
}

// ConcreteVisitor
class TaxVisitor implements Visitor {
    public void visit(Book book) 
    { System.out.println("Book: no tax"); }
    public void visit(Electronics electronics) 
    { System.out.println("Electronics: 18% tax"); }
}

// Client
public class VisitorDemo {
    public static void main(String[] args) {
        Item[] cart = { new Book(), new Electronics() };
        Visitor tax = new TaxVisitor();

        for (Item item : cart) {
            item.accept(tax); // each item lets the visitor decide what to do
        }
    }
}
