// Singleton
class SchoolPrincipal {
    private static SchoolPrincipal instance;

    private SchoolPrincipal() {} // private constructor prevents outside instantiation

    public static SchoolPrincipal getInstance() {
        if (instance == null) {
            instance = new SchoolPrincipal(); // created only once, on first request
        }
        return instance;
    }

    public void fileGrievance(String complaint) {
        System.out.println("Principal received grievance: " + complaint);
    }
}

// Client
public class SingletonDemo {
    public static void main(String[] args) {
        SchoolPrincipal principal1 = SchoolPrincipal.getInstance();
        SchoolPrincipal principal2 = SchoolPrincipal.getInstance();

        principal1.fileGrievance("Cafeteria food quality");

        System.out.println(principal1 == principal2); // true — every teacher/student reaches the same principal
    }
}
