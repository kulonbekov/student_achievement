package kg.mega.student_achievement.services.impl;

import kg.mega.student_achievement.dao.StudentRep;
import kg.mega.student_achievement.models.dtos.ExamDto;
import kg.mega.student_achievement.models.dtos.StudentDto;
import kg.mega.student_achievement.models.dtos.SubjectDto;
import kg.mega.student_achievement.models.entities.StudentAchievement;
import kg.mega.student_achievement.services.StudentAchService;
import kg.mega.student_achievement.services.StudentDtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDtoServiceImpl implements StudentDtoService {

    private final StudentAchService studentAchService;
    private final StudentRep studentRep;

    public StudentDtoServiceImpl(StudentAchService studentAchievementService,
                                 StudentRep studentRep) {
        this.studentAchService = studentAchievementService;
        this.studentRep = studentRep;
    }

    @Override
    public StudentDto getById(long id) {
        StudentAchievement studentAch = studentAchService.findById(id);

        StudentDto studentDto = new StudentDto();

        studentDto.setSurname(studentAch.getStudent().getFirstName());
        studentDto.setName(studentAch.getStudent().getFirstName());
        studentDto.setPatronymic(studentAch.getStudent().getPatronymic());
        studentDto.setScholarship(studentAch.getStudent().getScholarship().getScholarshipAmount());

        List<ExamDto> exams = new ArrayList<>();
        ExamDto examDto = new ExamDto();
        examDto.setDateExam(studentAch.getExam().getExamDate());
        examDto.setExamName(studentAch.getExam().getSubject().getName());
        examDto.setGrade(studentAch.getGrade());
        exams.add(examDto);

        List<SubjectDto> subjects = new ArrayList<>();
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setSubjectName(studentAch.getExam().getSubject().getName());
        subjectDto.setTeacherName(studentAch.getTeacher().getLastName() + " " + studentAch.getTeacher().getFirstName());
        subjectDto.setExams(exams);
        subjects.add(subjectDto);

        studentDto.setSubjects(subjects);

        return null;
    }
}
