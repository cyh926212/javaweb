package First;

public class Student {

    private String id;
    private String name;
    private String math;

    private String chinese;

    private String english;

    public Student() {

    }

    public Student(String id, String name,String math,String chinese,String english) {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getMath() {
        return this.math;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getChinese() {
        return this.chinese;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getEnglish() {
        return this.english;
    }

    public String toString() {
        return String.format("ID: %s, Name: %s", this.getId(), this.getName());
    }
}
