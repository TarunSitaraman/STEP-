public class Student {
    private String studentId, name, course;
    private double grade;
    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("Course: " + course);
    }
    public void calculateLetterGrade() {
        if (grade >= 90) {
            System.out.println("Letter Grade: A");
        } else if (grade >= 80) {
            System.out.println("Letter Grade: B");
        } else if (grade >= 70) {
            System.out.println("Letter Grade: C");
        } else if (grade >= 60) {
            System.out.println("Letter Grade: D");
        } else {
            System.out.println("Letter Grade: F");
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student("S0001", "John", 75.0, "Computer Science");
        Student student2 = new Student("S12345", "Alice", 85.5, "Mathematics");
        student1.setStudentId("S67890");    
        student1.setName("Bob");
        student1.setGrade(92.0);
        student1.setCourse("Physics");  
        student1.displayStudent();
        student1.calculateLetterGrade();
        student2.displayStudent();
        student2.calculateLetterGrade();
    }
}