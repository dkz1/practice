package schoolSys;

import java.util.ArrayList;

//老师类，继承于Person类
public class Teacher extends Person {

    //新增 教授课程、职称 的属性
    Course course;
    String rank;
    static final String[] rankList = {"教授","副教授","讲师","助教"};     //教师职称列表

    //构造函数

    public Teacher(String name, int number) {
        super(name, number);
    }

    //新增course的 setter getter 方法

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
