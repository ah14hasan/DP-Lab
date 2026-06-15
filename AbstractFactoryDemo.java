// ===== Abstract Products =====
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// ===== Concrete Products: Windows =====
class WindowsButton implements Button {
    public void render() { System.out.println("Rendering a Windows-style button."); }
}

class WindowsCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering a Windows-style checkbox."); }
}

// ===== Concrete Products: Mac =====
class MacButton implements Button {
    public void render() { System.out.println("Rendering a Mac-style button."); }
}

class MacCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering a Mac-style checkbox."); }
}

// ===== Abstract Factory =====
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// ===== Concrete Factories =====
class WindowsFactory implements GUIFactory {
    public Button createButton()     { return new WindowsButton(); }
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}

class MacFactory implements GUIFactory {
    public Button createButton()     { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

// ===== Client / Main =====
public class AbstractFactoryDemo {

    // Helper method: works with ANY factory — doesn't care which family it is.
    static void renderUI(GUIFactory factory) {
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        button.render();
        checkbox.render();
    }

    public static void main(String[] args) {
        System.out.println("--- Windows UI ---");
        renderUI(new WindowsFactory());

        System.out.println("\n--- Mac UI ---");
        renderUI(new MacFactory());
    }
}
