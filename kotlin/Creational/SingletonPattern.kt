class Singleton private constructor(value: String) {
    var value: String

    companion object {
        private var instance: Singleton? = null
        fun getInstance(value: String): Singleton? {
            if (instance == null) {
                instance = Singleton(value)
            }
            return instance
        }
    }

    init {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
        this.value = value
    }
}

fun main() {
    val singleton: Singleton? = Singleton.getInstance("FOO")
    val anotherSingleton: Singleton? = Singleton.getInstance("BAR")
    println(singleton?.value)
    println(anotherSingleton?.value)
}

/* Output
FOO
FOO
 */