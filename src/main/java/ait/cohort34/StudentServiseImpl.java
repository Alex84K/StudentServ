package ait.cohort34;

import ait.cohort34.student.dao.StudentRepository;
import ait.cohort34.student.dto.ScoreDto;
import ait.cohort34.student.dto.StudentAddDto;
import ait.cohort34.student.dto.StudentDto;
import ait.cohort34.student.dto.StudentUpdateDto;
import ait.cohort34.student.dto.exaptions.StudentNotFoundExeption;
import ait.cohort34.student.model.Student;
import ait.cohort34.student.servise.StudentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class StudentServiseImpl implements StudentServise {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Boolean addStudent(StudentAddDto studentAddDto) {
        if(studentRepository.findById(studentAddDto.getId()).isPresent()){
            return  false;
        }
        Student student = new Student(studentAddDto.getId(), studentAddDto.getName(), studentAddDto.getPassword());
        studentRepository.save(student);
        return null;
    }

    @Override
    public StudentDto findStudent(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(StudentNotFoundExeption::new);
        return new StudentDto(id, student.getName(), student.getScores());
    }

    @Override
    public StudentDto removeStudent(Integer id) {
        //studentRepository.remove(id); // не могу понять почему не работает
        return null;
    }

    @Override
    public StudentAddDto updateStudentDto(Integer id, StudentUpdateDto studentUpdateDto) {
        Student student = studentRepository.findById(id).orElseThrow(StudentNotFoundExeption::new);
        student.setName(studentUpdateDto.getName());
        student.setPassword(studentUpdateDto.getPassword());
        return null;
    }

    @Override
    public Boolean addScore(Integer id, ScoreDto scoreDto) {
        Student student = studentRepository.findById(id).orElseThrow(StudentNotFoundExeption::new);
        student.addScore(scoreDto.getExamName(), scoreDto.getScore());
        return null;
    }

    @Override
    public Iterable<StudentDto> findStudentByName(String name) {
        Student s = new Student();
        s.setName(name);
        Iterable<StudentDto> students = (Iterable<StudentDto>) studentRepository.findAll()
                .stream().filter(student -> student.equals(s));
        return students;
    }

    @Override
    public Long getStudentsNamesQuantity(Set<String> names) {
        return (long) names.size();
    }

    @Override
    public Iterable<StudentDto> findStudentByexamMinScore(String exam, Integer minScore) {
        Student s = new Student();
        s.addScore(exam, minScore);
        Iterable<StudentDto> students = (Iterable<StudentDto>) studentRepository.findAll()
                .stream().filter(student -> student.equals(s));
        return students;
    }
}
