class Student {
    String name;
    int id;
    double[] marks;
    double average;
    char grade;

    Student(String name, int id, int numSubjects) {
        this.name = name;
        this.id = id;
        marks = new double[numSubjects];
    }

    void setMarks(double[] marksList) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marksList[i];
        }
        average = calculateAverage();
        grade = assignGrade(average);
    }

    double calculateAverage() {
        double total = 0;
        for (double mark : marks) total += mark;
        return total / marks.length;
    }

    static char assignGrade(double avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }

    void display() {
        System.out.print("ID: " + id + ", Name: " + name +
            ", Marks: ");
        for (double mark : marks) System.out.print(mark + " ");
        System.out.println("Average: " + average + ", Grade: " + grade);
    }
}

class GradeManager {
    Student[] students = new Student[10];
    int count = 0;
    int numSubjects;

    GradeManager(int numSubjects) {
        this.numSubjects = numSubjects;
    }

    void addStudent(String name, int id, double[] marksList) {
        Student s = new Student(name, id, numSubjects);
        s.setMarks(marksList);
        students[count++] = s;
    }

    void updateMarks(int id, double[] newMarksList) {
        for (int i = 0; i < count; i++) {
            if (students[i].id == id) {
                students[i].setMarks(newMarksList);
                return;
            }
        }
    }

    void displayAll() {
        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }
}

public class StudentGradeApp {
    public static void main(String[] args) {
        GradeManager gm = new GradeManager(3); // Assume 3 subjects
        gm.addStudent("Arjun", 1, new double[] {85, 90, 80});
        gm.addStudent("Meena", 2, new double[] {78, 88, 67});

        gm.displayAll();
        gm.updateMarks(2, new double[] {90, 92, 88});
        gm.displayAll();
    }
}
