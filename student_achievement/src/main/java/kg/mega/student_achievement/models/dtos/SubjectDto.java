package kg.mega.student_achievement.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectDto {

    @JsonProperty("subject")
    String subjectName;
    @JsonProperty("Teacher")
    String teacherName;
    @JsonProperty("exams")
    List<ExamDto> exams;
}
