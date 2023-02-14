import org.junit.jupiter.api.Test
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import java.time.LocalDate
import kotlin.random.Random



class TestClass {


    @Test
    fun `test sort`() {

        val dateList = buildRandomDateList(3000)
        val sorted = dateList.sorted()

        val m1 = System.currentTimeMillis()
        println(sorted[sorted.size - 1])
        println(sorted[0])
        val m2 = System.currentTimeMillis()

        println(sorted.max())
        println(sorted.min())
        val m3 = System.currentTimeMillis()

        println(m2 - m1)
        println(m3 - m2)


    }

    private fun buildRandomDateList(size: Int): MutableList<LocalDate> {
        val result = mutableListOf<LocalDate>()
        val dayRandom = Random(30)
        val monthRandom = Random(12)
        val yearRandom = Random(2000)
        for (i in 0..size) {
            result.add(
                LocalDate.of(
                    yearRandom.nextInt(50) + 1980,
                    monthRandom.nextInt(11) + 1,
                    dayRandom.nextInt(28) + 1
                )
            )
        }
        return result
    }


}