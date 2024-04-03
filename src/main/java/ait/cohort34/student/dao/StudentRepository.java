package ait.cohort34.student.dao;

import ait.cohort34.student.model.Student;
import java.util.Optional;
import java.util.Collection;

public interface StudentRepository {
    Student save(Student student);

    Optional<Student> findById(int id);

    Collection<Student> findAll();
}
