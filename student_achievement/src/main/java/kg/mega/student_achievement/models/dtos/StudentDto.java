package kg.mega.student_achievement.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.mega.student_achievement.models.entities.Exam;
import kg.mega.student_achievement.models.entities.Subject;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {

    @JsonProperty("surname")
    String surname;
    @JsonProperty("name")
    String name;
    @JsonProperty("patronymic")
    String patronymic;
    @JsonProperty("address")
    String address;
    @JsonProperty("scholarship_amount")
    double scholarship;
    @JsonProperty("subjects")
    List<SubjectDto> subjects;



}
