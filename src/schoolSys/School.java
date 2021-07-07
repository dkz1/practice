package schoolSys;

import java.util.ArrayList;

/**
 * 定义一个学校类
 * 学校有的：
 *  名称、地址、院系、教职工、学生
 */
public class School {

    String name;
    String address;
    ArrayList<String> facultyList;  //学院列表
    ArrayList<Person> TeacherList;  //教师列表
    ArrayList<Student> studentList; //学生列表

    //以名称和地址为参数建立构造函数
    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //各种属性的设定获取方法


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(ArrayList<String> facultyList) {
        this.facultyList = facultyList;
    }

    public ArrayList<Person> getTeacherList() {
        return TeacherList;
    }

    public void setTeacherList(ArrayList<Person> TeacherList) {
        this.TeacherList = TeacherList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    //将院系加入学院列表
    public void addFacultyList(String facultyName){
        facultyList.add(facultyName);
    }
    //将教老师加入教职工列表
    public void addTeacherList(Teacher teacher){
        TeacherList.add(teacher);
    }
    //将学生加入学生列表
    public void addStudentList(Student student){
        studentList.add(student);
    }
}
