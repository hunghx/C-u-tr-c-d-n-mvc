package ra.view;

import ra.config.InputMethods;
import ra.controller.IController;
import ra.controller.UserController;
import ra.model.entity.User;

public class StudentManager {
    static UserController userController = new UserController();
    public static void main(String[] args) {
        while (true) {
            System.out.println("--------------------- MENU ----------------------");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Thoát");
            System.out.println("--------------------- MENU ----------------------");
            int choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    login();

                    break;
                case 2:
                    register();

                    break;
                case 3:
                    System.out.println("Goodbye !!!!");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhâp không hợp lệ, vui lòng chọn lại!");
            }

        }
    }

    public static void login() {
        System.out.print("username : ");
        String username = InputMethods.getString();
        System.out.print("\npassword: ");
        String password = InputMethods.getString();
        // xử lí đăng nhập

        User userLogin = userController.checkLogin(username, password);
        if (userLogin == null) {
            System.err.println("Sai tài khoản hoặc mật khẩu");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1. Đăng nhập lại ");
            System.out.println("2. Đăng ký ");
            System.out.println("Quay lại menu (press other key)");
            int choose = InputMethods.getByte();
            switch (choose) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                default:
                    break;
            }
        } else {
            if (userLogin.getPermission() == 1) {
                // chuyê đến view quản trị
                System.out.println("CHào mừng quản trị viên quay lại !");
            } else {
                if (!userLogin.isUserStatus()) {
                    System.err.println("Bạn đã bị khoá");
                } else {
                    System.out.println("Đăng nhập thành công");
                    //chuyển đến view người dùng
                }
            }
        }

    }

    public static void register() {
        User newUser = new User();
        System.out.print("\n Nhập fullname :");
        newUser.setFullName(InputMethods.getString());
        System.out.print("\n Nhập username :");
        newUser.setUserName(InputMethods.getString());
        System.out.print("\n Nhập password :");
        newUser.setPassword(InputMethods.getString());
        System.out.println("\n Nhập sđt :");
        newUser.setPhoneNumber(InputMethods.getString());
        newUser.setPermission(0);
        newUser.setUserStatus(true);
        userController.create(newUser);
        System.out.println("Thêm mới thành công vui lòng đăng nhập!!");
    }
}
