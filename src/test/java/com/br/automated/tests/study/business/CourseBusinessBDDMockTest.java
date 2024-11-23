package com.br.automated.tests.study.business;

import com.br.automated.tests.study.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.*;

class CourseBusinessBDDMockTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    void setup() {

        // Given / Arrange
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);

        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {

        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        // When / Act
        var filteredCourses =
                business.retriveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertThat(filteredCourses.size(), is(4));
    }

    @DisplayName("Delete Courses not Related to Spring Using Mockito sould call Method deleteCourse V1")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourseV1() {

        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        /*Verifica se deleteCourse foi chamado*/
        verify(mockService)
            .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");

        // times(1) Verifica se deleteCourse foi chamado apenas 1 vez
        verify(mockService, times(1))
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");

        /*never() - Verifica se deleteCourse não foi chamado*/
        verify(mockService, never())
                .deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");

        /*atLeast(1) ou atLeastOnce() - Verifica se deleteCourse foi chamado ao menos 1 vez*/
        // verify(mockService, atLeast(1))
        verify(mockService, atLeastOnce())
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
    }

    @DisplayName("Delete Courses not Related to Spring Using Mockito sould call Method deleteCourse V2")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourseV2() {

        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        /*Verifica se deleteCourse foi chamado*/
        then(mockService)
                .should()
                    .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");

        // times(1) Verifica se deleteCourse foi chamado apenas 1 vez
        then(mockService)
                .should(times(1))
                    .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");

        /*never() - Verifica se deleteCourse não foi chamado*/
        then(mockService)
                .should(never())
                .deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");

        /*atLeast(1) ou atLeastOnce() - Verifica se deleteCourse foi chamado ao menos 1 vez*/
        // atLeast(1))
        then(mockService, )
                .should(atLeastOnce())
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");


    }
}
