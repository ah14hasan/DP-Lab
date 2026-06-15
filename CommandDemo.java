// ===== Receivers (the objects that actually do the work) =====
class Light {
    public void turnOn()  { System.out.println("Light is ON"); }
    public void turnOff() { System.out.println("Light is OFF"); }
}

class Fan {
    public void start() { System.out.println("Fan is spinning"); }
    public void stop()  { System.out.println("Fan stopped"); }
}

// ===== Command interface =====
interface Command {
    void execute();
}

// ===== Concrete Commands (each wraps a Receiver + a specific action) =====
class LightOnCommand implements Command {
    private final Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

class LightOffCommand implements Command {
    private final Light light;
    public LightOffCommand(Light light) { this.light = light; }
    public void execute() { light.turnOff(); }
}

class FanStartCommand implements Command {
    private final Fan fan;
    public FanStartCommand(Fan fan) { this.fan = fan; }
    public void execute() { fan.start(); }
}

// ===== Invoker (knows how to trigger a command — but not what it does) =====
class RemoteControl {
    private Command command;

    public void setCommand(Command command) { this.command = command; }
    public void pressButton() { command.execute(); }
}

// ===== Main / Client =====
public class CommandDemo {
    public static void main(String[] args) {
        // Receivers
        Light light = new Light();
        Fan fan = new Fan();

        // Commands wrap "what to do" as objects
        Command turnLightOn  = new LightOnCommand(light);
        Command turnLightOff = new LightOffCommand(light);
        Command startFan     = new FanStartCommand(fan);

        // One invoker, many commands — the remote doesn't care what it controls
        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnLightOn);
        remote.pressButton();

        remote.setCommand(startFan);
        remote.pressButton();

        remote.setCommand(turnLightOff);
        remote.pressButton();
    }
}
