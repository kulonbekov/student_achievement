package kg.mega.student_achievement.models.entities;

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
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String lastName;
    String firstName;
    String patronymic;
    Boolean active;
    @ManyToOne
    @JoinColumn(name = "scholarship_id")
    Scholarship scholarship;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;

}
