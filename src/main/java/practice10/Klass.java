package practice10;

public class Klass {
    int number;
    private Student leader;

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

    public void assignLeader(Student jerry) {
        if (appendMember(jerry)) {
            leader =jerry;
        }
    }

    public Student getLeader() {
        return leader;
    }

    public boolean appendMember(Student stu) {
        if (stu.getKlass().equals(this)) {
            stu.setKlass(this);
        }else {
            System.out.print("It is not one of us.\n");
            return false;
        }
        return true;
    }
}
