package kg.mega.student_achievement.services.impl;

import kg.mega.student_achievement.dao.SubjectRep;
import kg.mega.student_achievement.models.entities.Subject;
import kg.mega.student_achievement.services.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRep subjectRep;

    public SubjectServiceImpl(SubjectRep subjectRep) {
        this.subjectRep = subjectRep;
    }


    @Override
    public Subject save(Subject subject) {
        return subjectRep.save(subject);
    }

    @Override
    public Subject findById(long id) {
        return subjectRep.findById(id).orElseThrow(()-> new RuntimeException("Предмет не найден"));
    }

    @Override
    public List<Subject> findAll() {
        return subjectRep.findAll();
    }

    @Override
    public Subject delete(long id) {
        Subject subject = findById(id);
        subject.setActive(false);
        return save(subject);
    }

    @Override
    public Subject update(long id) {
        return null;
    }
}
