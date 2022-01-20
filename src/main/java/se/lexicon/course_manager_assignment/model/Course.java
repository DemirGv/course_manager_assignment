package se.lexicon.course_manager_assignment.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

public class Course implements Serializable {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration, Collection<Student> students) {
        this.id=id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

//    public boolean enrollStudent(Student student) should be used to add a Student.class
//    object to Collection<Student> students. Make sure you avoid adding a duplicate or
//        null into the Collection. Should return true when student was successfully added,
//    otherwise false.

    public boolean enrollStudent (Student student){
        if (student == null) return false;
        if (students.contains(student)) return false;
        //students.add(student);
        return students.add(student);
    }

  //  public boolean unrollStudent(Student student)
//    should be used to remove a Student.class object from Collection<Student> students.
//            Returns true when the Student object was successfully removed.
  public boolean unrollStudent(Student student){
      if (student == null) return false;
        if(students.contains(student)) {
            //students.remove(student);
            return students.remove(student);
        }
        return false;
  }



    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getId() == course.getId() && getWeekDuration() == course.getWeekDuration() && getCourseName().equals(course.getCourseName()) && getStartDate().equals(course.getStartDate()) && Objects.equals(getStudents(), course.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCourseName(), getStartDate(), getWeekDuration(), getStudents());
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                '}';
    }
}
