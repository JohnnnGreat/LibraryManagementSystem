import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static LinkedList<Auth> authList = new LinkedList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Main.printAuth();

    }

    static void printAuth() {
        System.out.println("========CHOOSE AN OPTION======== \n 1. Admin Login \n 2. Student Login");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                adminFunctions();
                break;
            case 2:
                studentFunctions();
                break;
            default:
                printAuth();
        }
    }

    static void adminFunctions() {
        System.out.println("===== THIS IS THE ADMIN PORTAL====== \n ==========> LOGIN TO CONTINUE");
        System.out.println("========CHOOSE AN OPTION======== \n 1. Register \n 2. Login \n 3. Exit");


        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                Register();
                break;
            case 2:
                Login();
                break;
            case 3:
                printAuth();
        }
    }

    private static void Login() {
        boolean isMatch;

        System.out.println("Enter your name");
        String name = input.nextLine();
        System.out.println("Enter your email");
        String email = input.nextLine();


        for (Auth auth : authList) {
            if (auth.getEmail().equals(email) && auth.getName().equals(name)) {

                isMatch = true;

                System.out.println("Login Successfull");
                break;
            } else {
                System.out.println("Login Unsuccessfully, Try Again.....");
                adminFunctions();
                return;
            }
        }
    }

    static void studentFunctions() {


    }


    static void Register() {

        System.out.println("Enter your name");

        String name = input.nextLine();

        System.out.println("Enter your email address");
        String email = input.nextLine();

        Auth auth = new Auth();

        auth.setName(name);
        auth.setEmail(email);

        authList.add(auth);

        for (Auth authL : authList) {
            System.out.println(authL);
        }


        System.out.println("REGISTERED SUCCESSFULLY, PROCEED TO LOGIN");
        adminFunctions();

    }

}