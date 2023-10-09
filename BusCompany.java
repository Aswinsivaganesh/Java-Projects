package Projects;
import java.util.*;
class Driver{
    private int empId;
    private String name;
    private String serviceClass;

    public int getEmpId(){
        return empId;
    }
    public String getName(){
        return name;
    }
    public String getServiceClass(){
        return serviceClass;
    }
    public void details(){
        System.out.printf("%-10d%-16s%s\n",empId,name,serviceClass);
    }

    Driver(int empId,String name,String serviceClass){
        this.empId=empId;
        this.name=name;
        this.serviceClass=serviceClass;
    }
}

public class BusCompany {

    public static void findEmpById(Driver[] arr,int id) {
        int pos = -1;
        System.out.println("Id:       name:           Class:");
        for (int i = 0; i < arr.length; i++) {
            if (id == arr[i].getEmpId()) {
                pos = i;
            }
        }
        if (pos == -1) {
            System.out.println("No such id exist in the database!");
        } else {
            arr[pos].details();
        }
    }
    public static void findEmpByName(Driver[] arr,String name){
        int pos = -1;
        System.out.println("Id:       Name:           Class:");
        for (int i = 0; i < arr.length; i++) {
            if (name.equalsIgnoreCase(arr[i].getName())) {
                pos = i;
            }
        }
        if (pos == -1) {
            System.out.println("No such name exist in the database!");
        } else {
            arr[pos].details();
        }
    }
    public static void findEmpByServiceClass(Driver[] arr,String ServiceClass){
        int pos = -1;
        System.out.println("Id:       Name:           Class:");
        for (int i = 0; i < arr.length; i++) {
            if (ServiceClass.equalsIgnoreCase(arr[i].getServiceClass())) {
                pos = i;

                arr[i].details();
            }
        }
        System.out.println();
        if (pos == -1) {
            System.out.println("No such service class exist in the database!");
        }
    }

    public static void main(String[] args) {

        Driver emp1 = new Driver(1, "Ashok", "AC");
        Driver emp2 = new Driver(2, "Komesh", "nonAC");
        Driver emp3 = new Driver(3, "Bottle Mani", "sleeper");
        Driver emp4 = new Driver(4, "PPPerumaalu", "AC");
        Driver emp5 = new Driver(5, "KKMurugan", "sleeper");
        Driver[] arr = new Driver[]{emp1, emp2, emp3, emp4, emp5};
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("**********************");
            System.out.println("1-Search by empId.");
            System.out.println("2-Search by name.");
            System.out.println("3-Search by service class.");
            System.out.println("4-Exit");
            System.out.println("**********************");
            System.out.println("Your option:");

            option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter the ID:");
                    int id = scan.nextInt();
                    findEmpById(arr,id);
                    break;
                case 2:
                    System.out.print("Enter the name:");
                    String name = scan.next();
                    findEmpByName(arr,name);
                    break;
                case 3:
                    System.out.println("1-sleeper");
                    System.out.println("2-AC");
                    System.out.println("3-nonAC");
                    System.out.print("Your option:");
                    int ch = scan.nextInt();
                    switch(ch){
                        case 1 : findEmpByServiceClass(arr,"sleeper");
                        break;
                        case 2 : findEmpByServiceClass(arr,"AC");
                        break;
                        case 3 : findEmpByServiceClass(arr,"nonAC");
                        break;
                        default :
                            System.out.println("Enter a valid number.");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Enter a valid number:");
            }
        } while(true);
    }
}

