import entity.*;
import service.*;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        UserService userService = new UserService();
        AddressService addressService = new AddressService();
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        StudentCourseService studentCourseService = new StudentCourseService();

        System.out.println("Hello!");
        System.out.println("Come in - 1");
        System.out.println("Register - 2");
        String menuPoint = getInput();
        switch (menuPoint){
            case "1":
                System.out.println("Come in");
                System.out.print("Input your email: ");
                String emailCheck = getInput();
                System.out.print("Input your password: ");
                String passwordCheck = getInput();
                break;

            case "2":
                System.out.println("Registration");
                System.out.print("Input your email: ");
                String email = getInput();
                System.out.print("Input your password: ");
                String password = getInput();
                userService.checkUserEmail(email);
                System.out.println("Choose your role: ");
                System.out.println("ADMINISTRATOR - 1");
                System.out.println("USER - 2");
                String roleMenuPoint = getInput();
                switch (roleMenuPoint){
                    case "1":
                        User userAdmin = new User(email, password, Role.ADMINISTRATOR);
                        userService.addUser(userAdmin);
                        break;
                    case "2":
                         User userUser = new User(email, password, Role.USER);
                         userService.addUser(userUser);
                         break;
                }
                break;
        }
    }

    public static String getInput(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
