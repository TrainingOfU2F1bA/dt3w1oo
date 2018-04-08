package practice09;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return super.introduce()+" I am a Teacher. I teach "+(klass==null?"No Class.":("Class "+klass+"."));
    }

    public String introduceWith(Student student) {

        return super.introduce()+" I am a Teacher. I "+(!klass.equals(student.getKlass())?"don't ":"")+"teach "+student.getName()+".";
    }
}
