package dependency.service.coursedependencyservice.repository

import dependency.service.coursedependencyservice.entity.Course
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.data.repository.query.Param

interface CourseRepository : Neo4jRepository<Course, String> {

    @Query("MATCH (c:Course {name: \$courseName})-[:REQUIRES]->(p:Course) RETURN p")
    fun findDirectPrerequisites(@Param("courseName") courseName: String): List<Course>

    @Query("MATCH (c:Course {name: \$courseName})-[:REQUIRES*]->(p:Course) RETURN DISTINCT p")
    fun findTransitivePrerequisites(@Param("courseName") courseName: String): List<Course>
}