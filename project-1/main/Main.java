package main;

import student.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.startup(
                "http://10.122.7.154/javaweb/data/students.txt",
                "http://139.186.26.196/javaweb/data/math.txt",
                "http://139.186.26.196/javaweb/data/chinese.txt",
                "http://139.186.26.196/javaweb/data/english.txt"
        );
        main.execute();
        main.shutdown();
    }

    public void startup(String uriStudent, String ruiMath, String ruiChinese, String uriEnglish) throws IOException {
        List<Student> students = this.loadStudents(uriStudent);

        // 加载学生基本信息
        StudentManager manager = StudentManager.getInstance();
        students.forEach(s -> {
            manager.addStudent(s);
        });

        // 加载数学成绩
        Map<String, Integer> mathScores = ScoreReaderFactory.create(ruiMath).read();
        mathScores.forEach((id, score) -> {
            Student student = manager.getStudentById(id);
            student.setMath(score);
        });

        // 加载语文成绩
        Map<String, Integer> chineseScores = ScoreReaderFactory.create(ruiChinese).read();
        chineseScores.forEach((id, score) -> {
            manager.getStudentById(id).setChinese(score);
        });

        // 加载外语成绩
        Map<String, Integer> englishScores = ScoreReaderFactory.create(uriEnglish).read();
        englishScores.forEach((id, score) -> {
            manager.getStudentById(id).setEnglish(score);
        });

    }

    public void shutdown() {
        System.out.println("Bye bye !");
    }

    public void execute() throws IOException {
        StudentManager manager = StudentManager.getInstance();
        manager.printAll();

//        manager.saveAs("E:\\workspace\\students_backup.txt");

//        List<Student> students = manager.sortByTotal();
//        for (Student student : students) {
//            System.out.println(String.format("%s %s %s", student.getId(), student.getName(), student.getTotal()));
//        }
//
//         manager.printAll();
//
//        List<Student> students = manager.findByScore(ClassType.MATH, 80, 85);
//        for (Student student : students) {
//            System.out.println(String.format("%s %s %s", student.getId(), student.getName(), student.getMath()));
//        }
//        System.out.println("Total Student: " + this.studentManager.getTotalNumber());
//        String id = "222021321072053";
//        Student student = studentManager.findById(id);
//        System.out.println(student.toString());
//        studentManager.deleteById(id);
//        System.out.println("Total Student: " + studentManager.getTotalNumber());
//
//        this.studentManager.visit(new IStudentVisitor() {
//            @Override
//            public void visit(Student student) {
//                if (student.getName().startsWith("李")) {
//                    System.out.println(student.toString());
//                }
//            }
//        });
    }

    public List<Student> loadStudents(String uri) throws IOException {
        IStudentReader reader = StudentReaderFactory.create(uri);
        return reader.read();
    }

}
