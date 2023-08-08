package com.learningspringboot.cruddemo.dao;

import com.learningspringboot.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int theId);
}
