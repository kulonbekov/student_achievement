package kg.mega.student_achievement.models.entities;

import kg.mega.student_achievement.models.utils.DateUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "scholarships")
public class Scholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double scholarshipAmount;
    Date startDate;
    Date endDate;
    boolean active;
    @PrePersist
    protected void onCreate() {
        endDate = DateUtil.getINSTANCE().getEndDate();
        startDate = new Date();
    }

}

