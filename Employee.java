import java.io.*;
import java.util.*;

public class Employee implements Serializable {
    String ename, email, dob;
    int age;

    Employee(String ename, String email, String dob, int age) {
        this.ename = ename;
        this.email = email;
        this.dob = dob;
        this.age = age;

    }

    public String toString() {
        return ename + " " + email + " " + dob + " " + age;
    }
}

class EmployeeDtails {
    public static void main(String[] args) throws Exception {
        int choice = -1;
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file = new File("employees.txt");
        ArrayList<Employee> al = new ArrayList<Employee>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Employee>) ois.readObject();
            ois.close();
        }
        do {
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.DELETE");
            System.out.println("4.SEARCH");
            System.out.println("5.SORT BY ENAME IN ASCENDING ORDER");
            System.out.println("6.SORT BY ENAME IN DESCENDING ORDER");
            System.out.println("0.EXIT");
            System.out.print("Enter Your Choice : ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter how many employees(details) you want to add :");
                    int n = s.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter Employee Name : ");
                        String ename = s1.nextLine();

                        System.out.print("Enter Employee Email Address : ");
                        String email = s1.nextLine();

                        System.out.print("Enter Employee Date Of Birth : ");
                        String dob = s1.nextLine();

                        System.out.println("Enter Employee Age : ");
                        int age = s.nextInt();

                        al.add(new Employee(ename, email, dob, age));
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(al);
                    oos.close();
                    break;
                case 2:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();
                        System.out.println("--------------------------------------------------------------");
                        li = al.listIterator();
                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("--------------------------------------------------------------");
                    } else {
                        System.out.println("File not Exists......!");
                    }
                    System.out.println(al);
                    break;
                case 3:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();
                        boolean found = false;
                        System.out.println("Enter Employee Name To Delete");
                        String ename = s1.nextLine();
                        System.out.println("--------------------------------------------------------------");
                        li = al.listIterator();
                        while (li.hasNext()) {
                            Employee e = (Employee) li.next();
                            if (e.ename.equalsIgnoreCase(ename)) {
                                li.remove();
                                found = true;
                            }
                        }
                        if (found) {
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            System.out.println("Record Deleted Successfully..........!");
                        } else {
                            System.out.println("Record not Found......!");

                        }
                        System.out.println("---------------------------------------------------------");
                    } else {
                        System.out.println("File not Exists......!");
                    }
                    break;

                case 4:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();
                        boolean found = false;
                        System.out.println("Enter Employee Name To Search");
                        String ename = s1.nextLine();
                        System.out.println("--------------------------------------------------------------");
                        li = al.listIterator();
                        while (li.hasNext()) {
                            Employee e = (Employee) li.next();
                            if (e.ename.equalsIgnoreCase(ename)) {
                                System.out.println(e);
                                found = true;
                            }
                        }
                        if (!found)
                            System.out.println("Record not Found......!");
                        System.out.println("---------------------------------------------------------");
                    } else {
                        System.out.println("File not Exists......!");
                    }
                    break;
                case 5:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            public int compare(Employee e1, Employee e2) {
                                return e1.ename.compareTo(e2.ename);
                            }
                        });
                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(al);
                        oos.close();

                        System.out.println("--------------------------------------------------------------");
                        li = al.listIterator();
                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("--------------------------------------------------------------");
                    } else {
                        System.out.println("File not Exists......!");
                    }
                    break;
                case 6:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            public int compare(Employee e1, Employee e2) {
                                return e2.ename.compareTo(e1.ename);
                            }
                        });
                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(al);
                        oos.close();

                        System.out.println("--------------------------------------------------------------");
                        li = al.listIterator();
                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("--------------------------------------------------------------");
                    } else {
                        System.out.println("File not Exists......!");
                    }
                    break;

            }

        } while (choice != 0);
    }
}
