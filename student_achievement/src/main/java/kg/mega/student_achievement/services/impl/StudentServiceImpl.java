package kg.mega.student_achievement.services.impl;

import kg.mega.student_achievement.dao.StudentRep;
import kg.mega.student_achievement.models.entities.Student;
import kg.mega.student_achievement.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRep studentRep;

    public StudentServiceImpl(StudentRep studentRep) {
        this.studentRep = studentRep;
    }

    @Override
    public Student save(Student student) {
        return studentRep.save(student);
    }

    @Override
    public Student findById(long id) {
        return studentRep.findById(id).orElseThrow(()-> new RuntimeException("Студент не найден"));
    }

    @Override
    public List<Student> findAll() {
        return studentRep.findAll();
    }

    @Override
    public Student delete(long id) {
        Student student = findById(id);
        student.setActive(false);
        return save(student);
    }

    @Override
    public Student update(long id) {
        return null;
    }
}
