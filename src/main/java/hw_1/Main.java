package hw_1;

import hw_1.entities.*;
import hw_1.services.AdminService;
import hw_1.services.UserService;

public class Main {
    public static void main(String[] args) {
        System.out.println("App started");

        UserService userService = new UserService();
        AdminService adminService = new AdminService();
        User user = new User(1, "Vanya", "Petrovich", (short)25, "vanya@vas.net");
        Admin admin = new Admin(2, "Kolya", "Sanych", (short)26, "kolya@vas.net");

        userService.saveEmployee(user);
        userService.saveEmployee(admin);
        adminService.saveEmployee(user);
        adminService.saveEmployee(admin);
        userService.validateEmployee(admin);
        adminService.validateEmployee(user);

        System.out.println("App finished");
    }
}
