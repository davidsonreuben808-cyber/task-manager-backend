
package epmaapi.controller;

import epmaapi.dto.TaskRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import epmaapi.models.tasks_model;

@RestController
@CrossOrigin(origins = {
    "http://localhost:3000",
    "https://your-vercel-app.vercel.app"
})
public class TaskController {

    @GetMapping("/tasks/{userId}")
    public String getTasks(@PathVariable int userId) {

        tasks_model model = new tasks_model();

        return model.getAllTasks(userId);
    }


@PostMapping("/tasks")
public String addTask(@RequestBody TaskRequest request) {

    tasks_model model = new tasks_model();

    return model.addTask(
            request.getTask_name(),
            request.getDescription(),
            request.getDue_date(),
            request.getPriority(),
            request.getStatus(),
            request.getUser_id());

} 

@DeleteMapping("/tasks/{id}")
public String deleteTask(@PathVariable int id) {

    tasks_model model = new tasks_model();

    return model.deleteTask(id);
} 

@PutMapping("/tasks/{id}")
public String updateTask(@PathVariable int id,
                         @RequestBody TaskRequest request) {

    tasks_model model = new tasks_model();

    return model.updateTask (
            id,
            request.getTask_name(),
            request.getDescription(),
            request.getDue_date(),
            request.getPriority(),
            request.getStatus());

}}