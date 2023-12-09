package com.example.taskmanager.Controller;
import jakarta.validation.Valid;

import com.example.taskmanager.domain.Tasks;
import com.example.taskmanager.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/ListTasks")
    public String listTasks(Model model){
        List<Tasks> tasks = (List<Tasks>) taskRepository.findAll();
        if (tasks.isEmpty()){
            model.addAttribute("message", "UH OH LOOKS LIKE DATABASE IS EMPTY!");
        } else {
            model.addAttribute("tasks", tasks);
        }
        return "listTasks";
    }


    @RequestMapping("/NewTasks")
    public String newTasks(Model model){
        model.addAttribute("task", new Tasks());
        return "addTasks";
    }

    @PostMapping("/AddTasks")
    public String addTasks(@Valid @ModelAttribute("task") Tasks task, BindingResult result){
        if (result.hasErrors()){
            return "addTasks";
        }
        taskRepository.save(task);
        return "redirect:/ListTasks";
    }

    @GetMapping("/Complete")
    public String complete(@RequestParam int taskId, Model model) {
        if(taskRepository.findById(taskId) != null) {
            taskRepository.delete(taskRepository.findById(taskId));

        }else {
            model.addAttribute("error", "No Tasks of Id: " + taskId + " exist!");
            return "error";
        }
        return "redirect:/";
    }

        @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new TaskValidator(taskRepository));
    }
}
