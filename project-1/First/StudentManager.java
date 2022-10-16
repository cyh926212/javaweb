package First;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> students;

    public List<Student> getStudents() {
        if (this.students == null) {
            this.students = new ArrayList<>();
        }
        return this.students;
    }

    public void initializeFromFile(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty())  continue;
            Student student = this.createStudent(line);
            this.getStudents().add(student);
        }
        fileInputStream.close();
    }

    public int getTotalNumber() {
        return this.getStudents().size();
    }

    public void printAll() {
        for (Student student : this.getStudents()) {
            System.out.println(String.format("学号：%s, 姓名：%s", student.getId(), student.getName()));
        }
    }

    private Student createStudent(String line) {
        String[] vals = line.split("\t");
        Student student = new Student();
        student.setId(vals[0]);
        student.setName(vals[1]);
        return student;
    }

    public Student getStudentById(String id) {
        for (Student student : this.getStudents()) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    /*public Student findByScore(String classType, int min, int max){

    }*/

    public void saveAs(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        for (Student student : this.getStudents()) {
            writer.write(String.format("%s, %s\n", student.getName(), student.getId()));
        }
        writer.close();
    }

}
