package schoolSys;

/**
 * 学校所有人员类
 * 教职工有的：
 * 姓名、性别、年龄、工号/学号、所属院系、
 */
public class Person {

    String name;
    String sex;
    int age;
    int number;
    String faculty;

    public Person() {
    }

    public Person(String name, int number) {
        this.name = name;
        this.number = number;
    }

    //各种属性的设定与获取方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
