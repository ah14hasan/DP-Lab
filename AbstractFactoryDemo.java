// AbstractFactory
interface GUIFactory {
    Button createButton();
}
// AbstractProduct
interface Button { 
    void paint(); 
}
// ConcreteProduct
class WindowsButton implements Button {
    public void paint() 
    { System.out.println("Rendering a Windows-style button"); }
}
class MacButton implements Button {
    public void paint() 
    { System.out.println("Rendering a Mac-style button"); }
}
// ConcreteFactory
class WindowsFactory implements GUIFactory {
    public Button createButton() 
    { return new WindowsButton(); }
}
class MacFactory implements GUIFactory {
    public Button createButton() 
    { return new MacButton(); }
}
// Client
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        String os = "Mac"; // determined at runtime, e.g. via System.getProperty("os.name")
        GUIFactory factory = os.equals("Mac") ? new MacFactory() : new WindowsFactory();
        factory.createButton().paint();
    }
}
