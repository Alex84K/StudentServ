package ait.cohort34.student.controller;

import ait.cohort34.student.dto.ScoreDto;
import ait.cohort34.student.dto.StudentAddDto;
import ait.cohort34.student.dto.StudentDto;
import ait.cohort34.student.dto.StudentUpdateDto;
import ait.cohort34.student.servise.StudentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class StudentController {
    @Autowired
    private StudentServise studentServise;


    @PostMapping("/student")
    public Boolean addStudent(@RequestBody StudentAddDto studentAddDto) {
        return studentServise.addStudent(studentAddDto);
    }

    @GetMapping("/student/{id}")
    public StudentDto findStudent(@PathVariable Integer id) { // названия должны совпадать
        return studentServise.findStudent(id);
    }

    @DeleteMapping("/student/{id}")
    public StudentDto removeStudent(@PathVariable Integer id) {
        return studentServise.removeStudent(id);
    }

    @PutMapping("/student/{id}")
    public StudentAddDto updateStudentDto(@PathVariable Integer id, @RequestBody StudentUpdateDto studentUpdateDto) {
        return studentServise.updateStudentDto(id, studentUpdateDto);
    }

    @PutMapping("/score/student/{id}")
    public Boolean addScore(@PathVariable Integer id, @RequestBody ScoreDto scoreDto) {
        return studentServise.addScore(id, scoreDto);
    }

    @GetMapping("/score/student/{name}")
    public Iterable<StudentDto> findStudentByName(@PathVariable String name) {
        return studentServise.findStudentByName(name);
    }

    @PostMapping("/quantity/students")
    public Long getStudentsNamesQuantity(@RequestBody Set<String> names) {
        return studentServise.getStudentsNamesQuantity(names);
    }

    @GetMapping("/students/exam/{exam}/minscore/{minScore}")
    public Iterable<StudentDto> findStudentByexamMinScore(@PathVariable String exam, @PathVariable Integer minScore) {
        return studentServise.findStudentByexamMinScore(exam, minScore);
    }
}
