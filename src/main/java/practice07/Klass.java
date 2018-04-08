package practice07;

public class Klass {
    int number;

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

    public boolean equals(Klass obj) {
       return number ==obj.number;
    }

    public String getDisplayName() {
        return "Class "+number;
    }
}
