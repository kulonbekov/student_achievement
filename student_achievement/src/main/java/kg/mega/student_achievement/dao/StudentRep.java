package kg.mega.student_achievement.dao;

import kg.mega.student_achievement.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends JpaRepository<Student, Long> {
}
