package io.pigutty.udemy.Full.Stack.Project.services;

import io.pigutty.udemy.Full.Stack.Project.domain.Backlog;
import io.pigutty.udemy.Full.Stack.Project.domain.Project;
import io.pigutty.udemy.Full.Stack.Project.domain.ProjectTask;
import io.pigutty.udemy.Full.Stack.Project.exceptions.ProjectNotFoundException;
import io.pigutty.udemy.Full.Stack.Project.repositories.BacklogRepository;
import io.pigutty.udemy.Full.Stack.Project.repositories.ProjectRepository;
import io.pigutty.udemy.Full.Stack.Project.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask, String username){

        Backlog backlog = projectService.findProjectByIdentifier(projectIdentifier, username).getBacklog();

        projectTask.setBacklog(backlog);

        Integer BacklogSequence = backlog.getPTSequence();

        BacklogSequence++;

        backlog.setPTSequence(BacklogSequence);

        projectTask.setProjectSequence(projectIdentifier + "-" + BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);

        if (projectTask.getPriority() == null) {
            projectTask.setPriority(3);
        }
        if (projectTask.getStatus()=="" ||projectTask.getStatus() == null) {
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);

    }

    public Iterable<ProjectTask>findBacklogById(String id, String username){

        projectService.findProjectByIdentifier(id, username);

        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }


    public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id, String username){

        projectService.findProjectByIdentifier(backlog_id, username);

        ProjectTask projectTask= projectTaskRepository.findByProjectSequence(pt_id);

        if(projectTask==null){
            throw new ProjectNotFoundException("Project Task '"+pt_id+"' not found");
        }

        if(!projectTask.getProjectIdentifier().equals(backlog_id)){
            throw new ProjectNotFoundException("Project Task '"+pt_id+"' does not exist in project '"+backlog_id);
        }

        return projectTask;
    }

    public ProjectTask updateByProjectSequence(ProjectTask updatedTask, String backlog_id, String pt_id, String username){
        ProjectTask projectTask = findPTByProjectSequence(backlog_id,pt_id, username);

        projectTask = updatedTask;
        if (projectTask.getPriority()==0||projectTask.getPriority() == null) {
            projectTask.setPriority(3);
        }
        if (projectTask.getStatus().equals("") ||projectTask.getStatus() == null) {
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);
    }

    public void deletePTByProjectSequence(String backlog_id, String pt_id, String username){
        ProjectTask projectTask = findPTByProjectSequence(backlog_id, pt_id, username);

        projectTaskRepository.delete(projectTask);
    }

}
