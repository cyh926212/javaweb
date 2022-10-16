package First;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    private StudentManager studentManager = null;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.startup();
    }

    public void printMenu() {
        System.out.println("1. print all students");
        System.out.println("2. find by id");
        System.out.println("3. find by class score");
        System.out.println("4. find by score");
        System.out.println("5. sort by total");
        System.out.println("6. save data");
        System.out.println("7. quit");
    }

    public void startup() throws IOException {
        String filePath = "C:\\students.txt";
        this.studentManager = new StudentManager();
        this.studentManager.initializeFromFile(filePath);

        this.printMenu();
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        while(command != 7) {
            if (command == 1) {
                this.studentManager.printAll();
            } else if (command == 2) {
                this.getStudentById();
            } else if (command == 6) {
                this.savaAs();
            }
            command = scanner.nextInt();
        }
    }

    private void getStudentById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the id");
        Student student = this.studentManager.getStudentById(scanner.nextLine());
        if (student != null) {
            System.out.println("找到记录：" + student.toString());
        }
    }



    private void savaAs() throws IOException {
        this.studentManager.saveAs("E:new-students.txt");
    }

    private void exit() {
        System.out.println("Bye bye ！");
    }
}
