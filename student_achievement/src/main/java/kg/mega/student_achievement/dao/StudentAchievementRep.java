package kg.mega.student_achievement.dao;

import kg.mega.student_achievement.models.entities.StudentAchievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAchievementRep extends JpaRepository<StudentAchievement, Long> {
}
