package com.hssn.controllers;

import com.hssn.TaskerApplication;
import com.hssn.models.Task;
import com.hssn.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/tasks"})
public class TasksController {

    private TaskRepository repo;

    @Autowired
    public void setRepo(TaskRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path = {"","/"}, method = RequestMethod.GET)
    public Iterable<Task> index(){
        PageRequest pr = new PageRequest(0,3);
        return repo.findAll(pr);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Task show(@PathVariable int id){
        Task t = repo.findOne(id);
        return t;
    }
}
