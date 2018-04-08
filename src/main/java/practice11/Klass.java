package practice11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Klass {
    int number;
    private Student leader;
    private List<Teacher> teachers=new LinkedList<>();

    public Klass(int num) {
        this.number = num;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Klass) {
            if (((Klass)obj).getNumber()==number) {
                return true;
            }
        }
        return false;
    }

    public String getDisplayName() {
        return "Class "+number;
    }

    public void assignLeader(Student student) {
        if (this.equals(student.getKlass())) {
            leader =student;
            teachers.stream().forEach(teacher->teacher.awareofLeaderChange(this,student));
        }else {
            System.out.print("It is not one of us.\n");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public boolean appendMember(Student stu) {
        teachers.stream().forEach(teacher->teacher.awareofMemberChange(this,stu));
        stu.setKlass(this);
        return true;
    }

    public void addTecher(Teacher teacher){
        teachers.add(teacher);
    }
}
