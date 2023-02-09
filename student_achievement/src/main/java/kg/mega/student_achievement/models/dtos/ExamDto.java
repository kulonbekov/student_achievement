package kg.mega.student_achievement.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import kg.mega.student_achievement.models.enums.Grade;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamDto {

    @JsonFormat(pattern = "dd.MM.yyyy hh:mm")
    @JsonProperty("exam_date")
    Date dateExam;
    @JsonProperty("score")
    Grade grade;


}
