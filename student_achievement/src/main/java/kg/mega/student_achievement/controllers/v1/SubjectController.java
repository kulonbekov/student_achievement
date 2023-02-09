package kg.mega.student_achievement.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement.models.entities.Student;
import kg.mega.student_achievement.models.entities.Subject;
import kg.mega.student_achievement.services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Предмет")
@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {
    private final SubjectService subjectService;
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @PostMapping("/save")
    @ApiOperation("Сохранение")
    Subject save(@RequestBody Subject subject){return subjectService.save(subject);}

    @GetMapping("/findById")
    @ApiOperation("Поиск предмета по ID")
    Subject findById(@RequestParam Long id){return subjectService.findById(id);}

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех предметов")
    List<Subject> findAll(){return subjectService.findAll();}

    @DeleteMapping("/delete")
    @ApiOperation("Удаление по ID")
    Subject delete(@RequestParam Long id){
        return subjectService.delete(id);
    }

}
