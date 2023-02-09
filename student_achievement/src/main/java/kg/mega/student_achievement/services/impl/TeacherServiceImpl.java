package kg.mega.student_achievement.services.impl;

import kg.mega.student_achievement.dao.TeacherRep;
import kg.mega.student_achievement.models.entities.Teacher;
import kg.mega.student_achievement.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRep teacherRep;

    public TeacherServiceImpl(TeacherRep teacherRep) {
        this.teacherRep = teacherRep;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRep.save(teacher);
    }

    @Override
    public Teacher findById(long id) {
        return teacherRep.findById(id).orElseThrow(()-> new RuntimeException("Преподаватель не найден"));
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRep.findAll();
    }

    @Override
    public Teacher delete(long id) {
        Teacher teacher = findById(id);
        teacher.setActive(false);
        return save(teacher);
    }

    @Override
    public Teacher update(long id) {
        return null;
    }
}
