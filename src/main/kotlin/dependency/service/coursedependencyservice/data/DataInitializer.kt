package dependency.service.coursedependencyservice.data

import dependency.service.coursedependencyservice.entity.Course
import dependency.service.coursedependencyservice.repository.CourseRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(private val repository: CourseRepository) : CommandLineRunner {

    override fun run(vararg args: String) {
        repository.deleteAll()

        val math1 = Course("Mathematik 1")
        val math2 = Course("Mathematik 2")

        val prog1 = Course("Programmieren 1")
        val prog2 = Course("Programmieren 2")

        val se1 = Course("Software Engineering 1")
        val se2 = Course("Software Engineering 2")

        val projekt = Course("Bachelorprojekt")

        math2.prerequisites.add(math1)
        prog2.prerequisites.add(prog1)

        se1.prerequisites.add(prog2)
        se2.prerequisites.add(se1)

        projekt.prerequisites.addAll(listOf(se2, math2))

        val courseList: List<Course> = listOf(math1, math2, prog1, prog2, se1, se2, projekt)
        repository.saveAll(courseList)
    }
}