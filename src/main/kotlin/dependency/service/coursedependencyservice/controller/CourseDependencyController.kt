package dependency.service.coursedependencyservice.controller

import dependency.service.coursedependencyservice.entity.Course
import dependency.service.coursedependencyservice.repository.CourseRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dependencies")
class CourseDependencyController(private val repository: CourseRepository) {

    @GetMapping("/direct/{name}")
    fun getDirectPrerequisites(@PathVariable name: String): List<Course> {
        return repository.findDirectPrerequisites(name)
    }

    @GetMapping("/transitive/{name}")
    fun getTransitivePrerequisites(@PathVariable name: String): List<Course> {
        return repository.findTransitivePrerequisites(name)
    }
}