// ===== Subsystem classes (complex internal pieces the client shouldn't deal with directly) =====
class CPU {
    public void freeze()       { System.out.println("CPU: freezing");  }
    public void jump(long pos) { System.out.println("CPU: jumping to address " + pos); }
    public void execute()      { System.out.println("CPU: executing"); }
}

class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Memory: loading " + data.length + " bytes at address " + position);
    }
}

class HardDrive {
    public byte[] read(long sector, int size) {
        System.out.println("HardDrive: reading " + size + " bytes from sector " + sector);
        return new byte[size];
    }
}

// ===== Facade (simple, unified interface to the subsystem) =====
class ComputerFacade {
    private final CPU       cpu       = new CPU();
    private final Memory    memory    = new Memory();
    private final HardDrive hardDrive = new HardDrive();

    public void start() {
        System.out.println("--- Starting computer ---");
        cpu.freeze();
        byte[] bootData = hardDrive.read(0, 1024);
        memory.load(0, bootData);
        cpu.jump(0);
        cpu.execute();
        System.out.println("--- Computer is up ---");
    }
}

// ===== Main =====
public class FacadeDemo {
    public static void main(String[] args) {
        // The client only talks to the facade — one method call hides
        // all the intricate startup choreography behind it.
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
