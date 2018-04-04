package RxJavaCoroutinesBenchmarking

import io.reactivex.Observable
import kotlinx.coroutines.experimental.runBlocking
import org.openjdk.jmh.annotations.*
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

open class SimpleOperationBenchmark {

    fun longOperation(): LinkedList<Int> {
        val resultList = LinkedList<Int>()
        val counter = AtomicInteger()
        counter.set(0)
        for (i in 0 until 10_000) {
            val value = counter.incrementAndGet()
            resultList.add(value)
        }
        return resultList
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput, Mode.AverageTime)
    @Warmup(iterations = 7, time = 3, timeUnit = TimeUnit.SECONDS)
    @Threads(4)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testCoroutines(): LinkedList<Int> = runBlocking { longOperation() }

    @Benchmark
    @BenchmarkMode(Mode.Throughput, Mode.AverageTime)
    @Warmup(iterations = 7, time = 3, timeUnit = TimeUnit.SECONDS)
    @Threads(4)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    fun testRxJava(): LinkedList<Int> = Observable.fromCallable { longOperation() }.blockingFirst()

}
