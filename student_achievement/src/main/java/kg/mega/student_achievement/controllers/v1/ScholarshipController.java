package kg.mega.student_achievement.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement.models.entities.Scholarship;
import kg.mega.student_achievement.models.entities.Student;
import kg.mega.student_achievement.services.ScholarshipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Стипендия")
@RestController
@RequestMapping("/api/v1/scholarship")
public class ScholarshipController {
    private final ScholarshipService scholarshipService;
    public ScholarshipController(ScholarshipService scholarshipService) {
        this.scholarshipService = scholarshipService;
    }
    @PostMapping("/save")
    @ApiOperation("Сохранение")
    Scholarship save(@RequestBody Scholarship scholarship){return scholarshipService.save(scholarship);}

    @GetMapping("/findById")
    @ApiOperation("Поиск стипендии по ID")
    Scholarship findById(@RequestParam Long id){return scholarshipService.findById(id);}

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех стипендий")
    List<Scholarship> findAll(){return scholarshipService.findAll();}

    @DeleteMapping("/delete")
    @ApiOperation("Удаление по ID")
    Scholarship delete(@RequestParam Long id){
        return scholarshipService.delete(id);
    }

}
