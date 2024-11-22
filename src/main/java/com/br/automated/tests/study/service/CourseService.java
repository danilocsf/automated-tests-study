package com.br.automated.tests.study.service;

import java.util.List;

public interface CourseService {
    List<String> retrieveCourses(String student);
    List<String> doSomething(String student);
    void deleteCourse(String course);
}
