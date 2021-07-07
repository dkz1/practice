package schoolSys;

/**
 * 学生类
 * 学生需要有：
 * 姓名、性别、年龄、班级、学号、所属院系
 */
public class Student extends Person{
    //新增班级、学位属性
    String classname;
    String degree;
    static final String[] degreeList = {"学士","硕士","博士"};

    //根据姓名学号  可以创建一个学生对象
    public Student(String name, int number) {
        super(name, number);
    }

    //新增班级的 setter getter 方法

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
