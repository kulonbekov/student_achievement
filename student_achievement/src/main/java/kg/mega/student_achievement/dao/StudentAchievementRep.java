package kg.mega.student_achievement.dao;

import kg.mega.student_achievement.models.entities.StudentAchievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentAchievementRep extends JpaRepository<StudentAchievement, Long> {

    @Query(value = "select * from student_achievements where student_id = :id", nativeQuery = true)
    List<StudentAchievement> findAllByStudent (long id);
}
