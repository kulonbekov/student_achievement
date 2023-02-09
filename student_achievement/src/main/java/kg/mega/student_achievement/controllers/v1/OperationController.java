package kg.mega.student_achievement.controllers.v1;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement.models.dtos.StudentDto;
import kg.mega.student_achievement.services.StudentDtoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "1. Get and Post operations:")
@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {

    private final StudentDtoService studentDtoService;

    public OperationController(StudentDtoService studentDtoService) {
        this.studentDtoService = studentDtoService;
    }


    @GetMapping("/findById")
    @ApiOperation("Отчет об успеваемости студента по ID")
    StudentDto findById(@RequestParam Long id)
    {return studentDtoService.getById(id);}

}

