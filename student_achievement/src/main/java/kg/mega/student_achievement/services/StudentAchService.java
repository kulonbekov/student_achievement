package kg.mega.student_achievement.services;

import kg.mega.student_achievement.models.entities.StudentAchievement;

public interface StudentAchService {

    StudentAchievement save (StudentAchievement studentAchievement);

    StudentAchievement findById(long id);
}
