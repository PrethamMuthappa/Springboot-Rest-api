package com.example.demo.studentModel;

import com.example.demo.Studentservice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/users/v2/")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/names")
    public ModelAndView getnames(Model model){
        ModelAndView ModelAndView = new ModelAndView();
        ModelAndView.setViewName("names");
        model.addAttribute("lists",studentService.getnames());
        return ModelAndView;
    }

    @PostMapping("/students{student}")
    public void registerstudent(@RequestBody Student student){
        studentService.addnewNames(student);
    }
    @PostMapping("/studentsform")
    public ModelAndView formdata(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        studentService.formdata(student);
        return modelAndView;
    }

    //this route is for getting all the users when givien a starting letter(string)
    @GetMapping ("/findstudents{findstudents}")
    public List<Student> findc(@RequestParam String findstudents){
        return studentService.findc(String.valueOf(findstudents));
    }

    //for deleting
    @DeleteMapping("/students/delete{id}")
    public void deletestudent(@RequestParam int id){
        studentService.deleteid(id);
    }

    @PutMapping("students/update{id}")
    public void update(int id,@RequestParam(required = false) String name,@RequestParam(required = false) String email){
        studentService.update(id,name,email);
    }


}
