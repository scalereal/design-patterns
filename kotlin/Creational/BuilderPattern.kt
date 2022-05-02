import kotlin.properties.Delegates

data class House(
    var window: Int,
    var door: Int,
    var room: Int,
    var hasGarden: Boolean,
    var hasSwimmingPool: Boolean
) {

    private constructor(builder: HouseBuilder) : this(
        builder.window,
        builder.door,
        builder.room,
        builder.hasGarden,
        builder.hasSwimmingPool
    )

    class HouseBuilder {
        var window by Delegates.notNull<Int>()
        var door by Delegates.notNull<Int>()
        var room by Delegates.notNull<Int>()
        var hasGarden by Delegates.notNull<Boolean>()
        var hasSwimmingPool by Delegates.notNull<Boolean>()

        fun window(init: HouseBuilder.() -> Int) = apply { window = init() }
        fun door(init: HouseBuilder.() -> Int) = apply { door = init() }
        fun room(init: HouseBuilder.() -> Int) = apply { room = init() }
        fun hasGarden(init: HouseBuilder.() -> Boolean) = apply { hasGarden = init() }
        fun hasSwimmingPool(init: HouseBuilder.() -> Boolean) = apply { hasSwimmingPool = init() }
    }

    companion object {
        fun build(init: HouseBuilder.() -> Unit) = House(HouseBuilder().apply(init))
    }
}

fun main() {
    val house1 = House.build {
        window = 4
        door = 2
        room = 2
        hasGarden = false
        hasSwimmingPool = false
    }

    house1.hasGarden = true

    println(house1)
}

// Output: House(window=4, door=2, room=2, hasGarden=true, hasSwimmingPool=false)