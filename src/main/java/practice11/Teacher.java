package practice11;

import java.util.HashSet;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private HashSet<Klass> classes;

    public Teacher(int id, String name, int age, HashSet<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        classes.stream().forEach(s->s.addTecher(this));
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
                        "No Class." : ("Class "+ (classes!=null&&!classes.isEmpty()?classes.stream().
                        mapToInt(x->x.getNumber()).sorted().boxed().collect(Collectors.toList()).toString().replaceAll("\\[|\\]",""):"")
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

    public void awareofLeaderChange(Klass klass,Student student) {
        System.out.print("I am "+getName()+". I know "+student.getName()+" become Leader of "+klass.getDisplayName()+".\n");
    }
    public void awareofMemberChange(Klass klass,Student student) {
        System.out.print("I am "+getName()+". I know "+student.getName()+" has joined "+klass.getDisplayName()+".\n");
    }
}
