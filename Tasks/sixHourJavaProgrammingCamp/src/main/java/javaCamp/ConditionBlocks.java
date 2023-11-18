package javaCamp;

public class ConditionBlocks {
    public static void main(String[] args) {
        int grade = 55;

        if (grade >= 50) {
            System.out.println("Geçti");
        } else if (grade >= 40) {
            System.out.println("Bütünleme");
        } else {
            System.out.println("Kaldı");
        }
    }
}
