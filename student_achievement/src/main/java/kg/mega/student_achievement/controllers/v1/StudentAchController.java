package kg.mega.student_achievement.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement.models.entities.StudentAchievement;
import kg.mega.student_achievement.services.StudentAchService;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Сводная таблица")
@RestController
@RequestMapping("/api/v1/achievement")
public class StudentAchController {

    private final StudentAchService studentAchService;

    public StudentAchController(StudentAchService studentAchService) {
        this.studentAchService = studentAchService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    StudentAchievement save(@RequestBody StudentAchievement studentAchievement){
        return studentAchService.save(studentAchievement);}


    @GetMapping("/findById")
    @ApiOperation("Поиск студента по ID")
    StudentAchievement findById(@RequestParam Long id) {
        return studentAchService.findById(id);
    }
}
