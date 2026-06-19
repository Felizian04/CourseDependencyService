package dependency.service.coursedependencyservice.entity

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node("Course")
class Course(
    @Id
    val name: String,

    @Relationship(type = "REQUIRES", direction = Relationship.Direction.OUTGOING)
    var prerequisites: MutableSet<Course> = mutableSetOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Course) return false
        return name == other.name
    }

    override fun hashCode(): Int = name.hashCode()
}