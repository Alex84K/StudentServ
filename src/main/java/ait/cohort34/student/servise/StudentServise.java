package ait.cohort34.student.servise;

import ait.cohort34.student.dto.ScoreDto;
import ait.cohort34.student.dto.StudentAddDto;
import ait.cohort34.student.dto.StudentDto;
import ait.cohort34.student.dto.StudentUpdateDto;
import java.util.Set;

public interface StudentServise {
    Boolean addStudent(StudentAddDto studentAddDto);
    StudentDto findStudent(Integer id);
    StudentDto removeStudent(Integer id);
    StudentAddDto updateStudentDto(Integer id, StudentUpdateDto studentUpdateDto);
    Boolean addScore(Integer id, ScoreDto scoreDto);
    Iterable<StudentDto> findStudentByName(String name);
    Long getStudentsNamesQuantity(Set<String> names);
    Iterable<StudentDto> findStudentByexamMinScore(String exam, Integer minScore);
}
