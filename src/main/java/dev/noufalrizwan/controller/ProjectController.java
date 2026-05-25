package dev.noufalrizwan.controller;

import dev.noufalrizwan.model.Project;
import dev.noufalrizwan.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController
{
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects()
    {
        return new ResponseEntity<>(projectService.getAllProj(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) 
    {
    return ResponseEntity.ok(projectService.getProjectById(id));
       }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project proj)
    {
        return new ResponseEntity<>(projectService.addProj(proj),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProj(id);
    }

    @PutMapping("/{id}")
    public Project updateProj(@PathVariable Long id,@RequestBody Project updatedProj)
    {
      return   projectService.updateProj(id,updatedProj);
    }



}
