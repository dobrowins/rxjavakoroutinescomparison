Kotlin Coroutines and RxJava comparative benchmarking: Ultimate Edition
=======================================================================

**Disclaimer:** I am not in any way Alexey Schipilev, so this benchmark is probably suck balls. 
So for any person that would PR this repo with improvement that happens to live in Moscow -- I'd get a beer.

Repo was born after I saw [this](https://proandroiddev.com/kotlin-coroutines-vs-rxjava-an-initial-performance-test-68160cfc6723).
As good intentions of mr.Bresolin were -- it is no way of doing benchmarks in JVM world.
As not only we have benchmarking frameworks -- also we must consider CPU's errata's and basic equipment wear down. 
So benchmarking performed at Samsung Galaxy S6 can't be taken seriously. Because it is Samsung running Android. 
And when it comes to Android Samsung just can't hold it's shit together.

So I took the liberty and performed similar benchmark using **JMH**. To pretend like I know what I am doing.

To repeat the benchmark clone the repo and perform next terminal commands:
* `mvn -Dkotlin.version=%KOTLIN.VERSION% clean compile`
* `mvn install`
* `java -jar target/benchmarks.jar`
* and enjoy!

Me personally at my `Ubuntu 17.10 with Intel® Core™ i5-3570 CPU @ 3.40GHz × 4 and 16GB RAM` got next results:

|Benchmark  | Mode  | Cnt | Score |  Error  |  Units |
|-----------|:-----:|:---:|:-----:|:-------:|:------:|
|Coroutines | thrpt | 200 | 7.477 | ± 0.026 | ops/ms |
|RxJava     | thrpt | 200 | 6.693 | ± 0.018 | ops/ms |
|Coroutines |  avgt | 200 | 0.134 | ± 0.001 | ms/op  |
|RxJava     |  avgt | 200 | 0.151 | ± 0.001 | ms/op  |


