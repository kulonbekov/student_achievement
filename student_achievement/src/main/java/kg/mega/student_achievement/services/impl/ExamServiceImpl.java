package kg.mega.student_achievement.services.impl;

import kg.mega.student_achievement.dao.ExamRep;
import kg.mega.student_achievement.models.entities.Exam;
import kg.mega.student_achievement.services.ExamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRep examRep;

    public ExamServiceImpl(ExamRep examRep) {
        this.examRep = examRep;
    }

    @Override
    public Exam save(Exam exam) {
        return examRep.save(exam);
    }
    @Override
    public Exam findById(long id) {
        return examRep.findById(id).orElseThrow(()-> new RuntimeException("Экзамен не найден"));
    }

    @Override
    public List<Exam> findAll() {
        return examRep.findAll();
    }

    @Override
    public Exam delete(long id) {
        Exam exam = findById(id);
        exam.setActive(false);
        return save(exam);
    }

    @Override
    public Exam update(long id) {
        return null;
    }
}
