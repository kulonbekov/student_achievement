package kg.mega.student_achievement.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement.dao.TeacherRep;
import kg.mega.student_achievement.models.entities.Teacher;
import kg.mega.student_achievement.services.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Преподаватель")
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/save")
    @ApiOperation("Сохранение")
    Teacher save(@RequestBody Teacher teacher){return teacherService.save(teacher);}

    @GetMapping("/findById")
    @ApiOperation("Поиск преподавателя по ID")
    Teacher findById(@RequestParam Long id){return teacherService.findById(id);}

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех преподавателей")
    List<Teacher> findAll(){return teacherService.findAll();}

    @DeleteMapping("/delete")
    @ApiOperation("Удаление по ID")
    Teacher delete(@RequestParam Long id){
        return teacherService.delete(id);
    }

}
