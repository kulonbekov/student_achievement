package kg.mega.student_achievement.models.entities;

import kg.mega.student_achievement.models.enums.Grade;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Student_achievements")
public class StudentAchievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
    @ManyToOne
    @JoinColumn(name = "exam_id")
    Exam exam;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;
    @Enumerated(EnumType.STRING)
    Grade grade;
}
