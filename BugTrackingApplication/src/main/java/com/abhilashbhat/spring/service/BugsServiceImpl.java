package com.abhilashbhat.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhilashbhat.spring.model.Bugs;
import com.abhilashbhat.spring.repository.BugsRepository;

@Service
public class BugsServiceImpl implements BugsService {

    @Autowired
    private BugsRepository bugRepository;

    @Override
    public List < Bugs > getAllBugs() {
        return bugRepository.findAll();
    }

    @Override
    public void saveBug(Bugs bug) {
        this.bugRepository.save(bug);
    }

    @Override
    public Bugs getBugById(long bugid) {
        Optional < Bugs > optional = bugRepository.findById(bugid);
        Bugs bug = null;
        if (optional.isPresent()) {
            bug = optional.get();
        } else {
            throw new RuntimeException(" Bug not found for id :: " + bugid);
        }
        return bug;
    }

    @Override
    public void deleteBugById(long bugid) {
        this.bugRepository.deleteById(bugid);
    }
}
