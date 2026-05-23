package dev.noufalrizwan.service;

import dev.noufalrizwan.model.Project;
import dev.noufalrizwan.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService
{
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProj()
    {
        return projectRepository.findAll();
    }

    public Project addProj(Project proj)
    {
       return projectRepository.save(proj);
    }

    public void deleteProj(long id)
    {
        projectRepository.deleteById(id);
    }

    public Project updateProj(Long id,Project updatedProj)
    {
       Project existingProj = projectRepository.findById(id).get();

       existingProj.setTitle(updatedProj.getTitle());
       existingProj.setDescription(updatedProj.getDescription());
       existingProj.setGithubLink(updatedProj.getGithubLink());
       existingProj.setTechnologies(updatedProj.getTechnologies());
       return projectRepository.save(existingProj);
    }



}
