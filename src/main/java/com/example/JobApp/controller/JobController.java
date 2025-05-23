package com.example.JobApp.controller;

import com.example.JobApp.model.JobPost;
import com.example.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @RequestMapping({"/","home"})
    public String home() {
        return "home";
    }

    @GetMapping("/addjob")
    public String addJobForm(Model model) {
        JobPost jobPost = new JobPost();
        model.addAttribute("jobPost",jobPost);
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String HandleForm(@ModelAttribute("jobPost") JobPost jobPost,Model model) {
        model.addAttribute("jobPost",jobPost);
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {
        List<JobPost> jobs = service.getAllJobs();
        model.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }

}
