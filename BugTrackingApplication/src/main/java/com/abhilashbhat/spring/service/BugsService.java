package com.abhilashbhat.spring.service;

import java.util.List;
import com.abhilashbhat.spring.model.Bugs;


public interface BugsService {
	List < Bugs > getAllBugs();
    void saveBug(Bugs bug);
    Bugs getBugById(long bugid);
    void deleteBugById(long bugid);
}
