// AbstractExpression
interface Expression {
    int interpret();
}

// TerminalExpression
class Number implements Expression {
    private final int value;
    public Number(int value) 
    { this.value = value; }
    public int interpret() 
    { return value; }
}

// NonterminalExpression
class Add implements Expression {
    private final Expression left, right;
    public Add(Expression left, Expression right) 
    { this.left = left; this.right = right; }
    public int interpret() 
    { return left.interpret() + right.interpret(); } // recurses down the tree
}

// Client
public class InterpreterDemo {
    public static void main(String[] args) {
        Expression expr = new Add(new Number(3), new Number(5)); // represents "3 + 5"
        System.out.println(expr.interpret()); // 8
    }
}
