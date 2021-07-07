package schoolSys;


import java.util.ArrayList;

//课程类，其属性包含：课程名称、上课班级、上课教室、上课老师
public class Course {
    String name;
    ArrayList<String> classList; //上课班级的list，需要能够增加、删除班级，用list
    Grade grade; //表示班级
    Teacher teacher;

    //构造方法，课程名称和上课老师一般是固定不变的，以此构建课程对象
    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getClassList() {
        return classList;
    }

    public void setClassList(ArrayList<String> classList) {
        this.classList = classList;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
