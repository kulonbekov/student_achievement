package kg.mega.student_achievement.services.impl;

import kg.mega.student_achievement.dao.ScholarshipRep;
import kg.mega.student_achievement.models.entities.Scholarship;
import kg.mega.student_achievement.services.ScholarshipService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScholarshipServiceImpl implements ScholarshipService {

    private final ScholarshipRep scholarshipRep;

    public ScholarshipServiceImpl(ScholarshipRep scholarshipRep) {
        this.scholarshipRep = scholarshipRep;
    }


    @Override
    public Scholarship save(Scholarship scholarship) {
        return scholarshipRep.save(scholarship);
    }

    @Override
    public Scholarship findById(long id) {
        return scholarshipRep.findById(id).orElseThrow(()-> new RuntimeException("Стипендия не найдена"));
    }

    @Override
    public List<Scholarship> findAll() {
        return scholarshipRep.findAll();
    }

    @Override
    public Scholarship delete(long id) {
        Scholarship scholarship = findById(id);
        scholarship.setActive(false);
        scholarship.setEndDate(new Date());
        return save(scholarship);
    }

    @Override
    public Scholarship update(long id) {
        return null;
    }
}
