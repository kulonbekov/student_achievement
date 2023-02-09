package kg.mega.student_achievement.services.impl;

import kg.mega.student_achievement.dao.StudentAchievementRep;
import kg.mega.student_achievement.models.entities.StudentAchievement;
import kg.mega.student_achievement.services.StudentAchService;
import org.springframework.stereotype.Service;

@Service
public class StudentAchServiceImpl implements StudentAchService {

    private final StudentAchievementRep rep;

    public StudentAchServiceImpl(StudentAchievementRep rep) {
        this.rep = rep;
    }

    @Override
    public StudentAchievement findById(long id) {
        return rep.findById(id).orElseThrow(()-> new RuntimeException("Не найдено"));
    }
}
