package kg.mega.student_achievement.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement.models.entities.Exam;
import kg.mega.student_achievement.services.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Экзамен")
@RestController
@RequestMapping("/api/v1/exam")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    Exam save(@RequestBody Exam exam){return examService.save(exam);}

    @GetMapping("/findById")
    @ApiOperation("Поиск экзамена по ID")
    Exam findById(@RequestParam Long id){return examService.findById(id);}

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех экзаменов")
    List<Exam> findAll(){return examService.findAll();}

    @DeleteMapping("/delete")
    @ApiOperation("Удаление по ID")
    Exam delete(@RequestParam Long id){
        return examService.delete(id);
    }

}
