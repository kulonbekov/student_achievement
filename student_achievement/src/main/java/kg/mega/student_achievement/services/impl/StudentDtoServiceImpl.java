package kg.mega.student_achievement.services.impl;

import kg.mega.student_achievement.dao.StudentAchievementRep;
import kg.mega.student_achievement.dao.StudentRep;
import kg.mega.student_achievement.models.dtos.*;
import kg.mega.student_achievement.models.entities.StudentAchievement;
import kg.mega.student_achievement.services.StudentAchService;
import kg.mega.student_achievement.services.StudentDtoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDtoServiceImpl implements StudentDtoService {

    private final StudentAchService studentAchService;
    private final StudentAchievementRep studentAchRep;



    public StudentDtoServiceImpl(StudentAchService studentAchievementService,
                                 StudentRep studentRep, StudentAchievementRep studentAchRep) {
        this.studentAchService = studentAchievementService;
        this.studentAchRep = studentAchRep;

    }

    @Override

    public StudentDto getById(long id) {
        List<StudentAchievement> studentAchs = studentAchRep.findAllByStudent(id);

        StudentDto studentDto = new StudentDto();
        List<SubjectDto> subjects = new ArrayList<>();

        for (int i = 0; i < studentAchs.size(); i++) {


        studentDto.setSurname(studentAchs.get(i).getStudent().getLastName());
        studentDto.setName(studentAchs.get(i).getStudent().getFirstName());
        studentDto.setPatronymic(studentAchs.get(i).getStudent().getPatronymic());
        studentDto.setAddress(studentAchs.get(i).getStudent().getAddress());
        studentDto.setScholarship(studentAchs.get(i).getStudent().getScholarship().getScholarshipAmount());


        ExamDto examDto = new ExamDto();
        examDto.setDateExam(studentAchs.get(i).getExam().getExamDate());
        examDto.setGrade(studentAchs.get(i).getGrade());



        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setSubjectName(studentAchs.get(i).getExam().getSubject().getName());
        subjectDto.setTeacherName(studentAchs.get(i).getTeacher().getLastName() + " " + studentAchs.get(i).getTeacher().getFirstName());
        subjectDto.setExam(examDto);
        subjects.add(subjectDto);

        studentDto.setSubjects(subjects);
        }
        return studentDto;
    }
}
