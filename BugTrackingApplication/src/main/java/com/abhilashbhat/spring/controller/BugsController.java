package com.abhilashbhat.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.abhilashbhat.spring.model.Bugs;
import com.abhilashbhat.spring.service.BugsService;

@Controller
public class BugsController {

    @Autowired
    private BugsService bugService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listBugs", bugService.getAllBugs());
        return "index";
    }

    @GetMapping("/showNewBugForm")
    public String showNewBugForm(Model model) {
        Bugs bug = new Bugs();
        model.addAttribute("bug", bug);
        return "new_bug";
    }

    @PostMapping("/saveBug")
    public String saveBug(@ModelAttribute("bug") Bugs bug) {
        
    	bugService.saveBug(bug);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{bugid}")
    public String showFormForUpdate(@PathVariable(value = "bugid")long bugid, Model model) {

        Bugs bug = bugService.getBugById(bugid);

        model.addAttribute("bug", bug);
        return "update_bug";
    }

    @GetMapping("/deleteBug/{bugid}")
    public String deleteBug(@PathVariable(value = "bugid") long bugid) {

        this.bugService.deleteBugById(bugid);
        return "redirect:/";
    }
}
