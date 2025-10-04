public class Course {
    String title;
    String instructor;
    String enrollmentDate;

    Course(String title, String instructor, String enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }

    void showProgress() {
        System.out.println("Progress tracking is not defined.");
    }

    void showBasicInfo() {
        System.out.println("Title: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Enrolled: " + enrollmentDate);
    }
}

class VideoCourse extends Course {
    int completionPercent;
    int watchTimeMinutes;

    VideoCourse(String title, String instructor, String enrollmentDate,
                int completionPercent, int watchTimeMinutes) {
        super(title, instructor, enrollmentDate);
        this.completionPercent = completionPercent;
        this.watchTimeMinutes = watchTimeMinutes;
    }

    @Override
    void showProgress() {
        System.out.println("Completion: " + completionPercent + "%");
        System.out.println("Watch Time: " + watchTimeMinutes + " minutes");
    }
}

class InteractiveCourse extends Course {
    int quizScore;
    int projectsCompleted;

    InteractiveCourse(String title, String instructor, String enrollmentDate,
                      int quizScore, int projectsCompleted) {
        super(title, instructor, enrollmentDate);
        this.quizScore = quizScore;
        this.projectsCompleted = projectsCompleted;
    }

    @Override
    void showProgress() {
        System.out.println("Quiz Score: " + quizScore);
        System.out.println("Projects Completed: " + projectsCompleted);
    }
}

class ReadingCourse extends Course {
    int pagesRead;
    int notesTaken;

    ReadingCourse(String title, String instructor, String enrollmentDate,
                  int pagesRead, int notesTaken) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.notesTaken = notesTaken;
    }

    @Override
    void showProgress() {
        System.out.println("Pages Read: " + pagesRead);
        System.out.println("Notes Taken: " + notesTaken);
    }
}

class CertificationCourse extends Course {
    int examAttempts;
    boolean isCertified;

    CertificationCourse(String title, String instructor, String enrollmentDate,
                        int examAttempts, boolean isCertified) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = examAttempts;
        this.isCertified = isCertified;
    }

    @Override
    void showProgress() {
        System.out.println("Exam Attempts: " + examAttempts);
        System.out.println("Certification Status: " + (isCertified ? "Certified" : "Not Certified"));
    }
}

class Main {
    public static void main(String[] args) {
        Course course1 = new VideoCourse("Java Basics", "Dr. Smith", "2025-09-24", 80, 120);
        Course course2 = new InteractiveCourse("Web Dev Bootcamp", "Ms. Lee", "2025-09-07", 92, 3);
        Course course3 = new ReadingCourse("Algorithms eBook", "Mr. Kumar", "2025-08-20", 150, 20);
        Course course4 = new CertificationCourse("AWS Certification", "Mrs. Gupta", "2025-07-16", 2, true);

        course1.showBasicInfo();
        course1.showProgress();
        System.out.println();

        course2.showBasicInfo();
        course2.showProgress();
        System.out.println();

        course3.showBasicInfo();
        course3.showProgress();
        System.out.println();

        course4.showBasicInfo();
        course4.showProgress();
    }
}
