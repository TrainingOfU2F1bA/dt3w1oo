package practice10;

import com.google.common.collect.Multimap;

import java.util.HashSet;

public class Teacher extends Person {
    private HashSet<Klass> classes;

    public Teacher(int id, String name, int age, HashSet<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public String introduce() {
        boolean b = classes == null || classes.isEmpty();
        return super.introduce() + " I am a Teacher. I teach " +
                (b ?
                        "No Class." : ("Class "+ (classes!=null&&!classes.isEmpty()?classes.toString().replaceAll("\\[|\\]", ""):"")
                                + "."));
    }

    public String introduceWith(Student student) {

        return super.introduce() + " I am a Teacher. I " + (!classes.contains(student.getKlass()) ? "don't " : "") + "teach " + student.getName() + ".";
    }

    public HashSet<Klass> getClasses() {
        return classes;
    }

    public boolean isTeaching(Student jerry) {
        return classes.contains(jerry.getKlass());
    }
}
