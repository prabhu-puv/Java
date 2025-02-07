public class Student {
    String name;
    int rollno;
    public Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }
 
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("rollno: " + rollno);
    }

    public static void main(String[] args) {
        Student student1 = new Student("Prabhu", 61);
        student1.display();
    }
}
