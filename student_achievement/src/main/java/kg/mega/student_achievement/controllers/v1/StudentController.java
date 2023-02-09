package kg.mega.student_achievement.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement.models.entities.Student;
import kg.mega.student_achievement.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Студент")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/save")
    @ApiOperation("Сохранение")
    Student save(@RequestBody Student student){return studentService.save(student);}

    @GetMapping("/findById")
    @ApiOperation("Поиск студента по ID")
    Student findById(@RequestParam Long id){return studentService.findById(id);}

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех студентов")
    List<Student> findAll(){return studentService.findAll();}

    @DeleteMapping("/delete")
    @ApiOperation("Удаление по ID")
    Student delete(@RequestParam Long id){
        return studentService.delete(id);
    }

}
