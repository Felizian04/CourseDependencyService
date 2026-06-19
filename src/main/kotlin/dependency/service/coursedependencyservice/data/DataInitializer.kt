package dependency.service.coursedependencyservice.data

import dependency.service.coursedependencyservice.entity.Course
import dependency.service.coursedependencyservice.repository.CourseRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(private val repository: CourseRepository) : CommandLineRunner {

    override fun run(vararg args: String) {
        repository.deleteAll()

        val gm = Course("Grundlagen der Mathematik")
        val gwi = Course("Grundlagen der Wirtschaftsinformatik")
        val pm1 = Course("Programmiermethodik 1")
        val pt = Course("Programmiertechnik")
        val bwl1 = Course("Betriebswirtschaft I")

        val qm = Course("Quantitative Methoden")
        val th = Course("Theoretische Informatik")
        val in1 = Course("Informationssysteme I")
        val pm2 = Course("Programmiermethodik II")
        val bwl2 = Course("Betriebswirtschaft 2")

        val ws = Course("Wahrscheinlichkeitsrechnung und Statistik")
        val ad = Course("Algorithmen und Datenstrukturen")
        val sea1 = Course("Software Engineering & Architektur 1")
        val wi1 = Course("Wirtschaftsinformatik I")
        val bwl3 = Course("Betriebswirtschaft 3")

        val bwl4 = Course("Betriebswirtschaft 4")
        val sea2 = Course("Software Engineering & Architektur 2")
        val rb = Course("Rechnernetze & Betriebssysteme")
        val wi2 = Course("Wirtschaftsinformatik II")
        val in2 = Course("Informationssysteme II")

        val wi3 = Course("Wirtschaftsinformatik III")
        val recht = Course("Recht")

        qm.prerequisites.addAll(listOf(gm, gwi))
        th.prerequisites.addAll(listOf(gwi, gm))
        in1.prerequisites.addAll(listOf(pm1, pt, gwi, gm))
        pm2.prerequisites.addAll(listOf(pm1, pt))
        bwl2.prerequisites.add(bwl1)

        ws.prerequisites.addAll(listOf(gm, qm, gwi))
        ad.prerequisites.addAll(listOf(pm1, pt, pm2))
        sea1.prerequisites.addAll(listOf(pm1, pt, pm2, in1))
        wi1.prerequisites.add(gwi)
        bwl3.prerequisites.addAll(listOf(bwl1, bwl2))

        bwl4.prerequisites.addAll(listOf(bwl1, bwl2, bwl3))
        sea2.prerequisites.addAll(listOf(pm2, in1, sea1))
        rb.prerequisites.addAll(listOf(pm1, pt, pm2))
        in2.prerequisites.addAll(listOf(in1, gm, gwi, pt, pm2))

        wi3.prerequisites.addAll(listOf(wi1, wi2))
        recht.prerequisites.addAll(listOf(rb, sea1, sea2, ad))

        val courseList: List<Course> = listOf(
            gm, gwi, pm1, pt, bwl1,
            qm, th, in1, pm2, bwl2,
            ws, ad, sea1, wi1, bwl3,
            bwl4, sea2, rb, wi2, in2,
            wi3, recht
        )

        repository.saveAll(courseList)
    }
}