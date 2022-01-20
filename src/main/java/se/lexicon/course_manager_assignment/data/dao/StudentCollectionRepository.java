package se.lexicon.course_manager_assignment.data.dao;


import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student student = new Student(StudentSequencer.getStudentSequencer(),name,email,address);
        students.add(student);
        return student;

    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        if(email==null) return null;
        for (Student student:students) {
            if(student.getEmail().equalsIgnoreCase(email)) return student;
        }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        if(name==null) return null;
        List<Student> studentList = new ArrayList<>();
        for (Student student:students) {
            if(student.getName().equalsIgnoreCase(name)) studentList.add(student);
        }
        return studentList;
    }

    @Override
    public Student findById(int id) {
        if(id==0) return null;
       // List<Student> studentList = new ArrayList<>();
        for (Student student:students) {
            if(student.getId()==id) return student;
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return students;
    }

    @Override
    public boolean removeStudent(Student student) {
        if(student==null) return false;
        return students.remove(student);
    }

    @Override
    public void clear() {
        this.students = new ArrayList<>();
    }
}
