enum class DeliveryType {
    ROAD,
    AIR;
}

interface Transport {
    fun planDelivery(): String
    fun getTransportType(): DeliveryType
}

class Truck : Transport {
    override fun planDelivery(): String {
        return "Inside Road Transport"
    }

    override fun getTransportType() = DeliveryType.ROAD
}

class Air : Transport {
    override fun planDelivery(): String {
        return "Inside Air Transport"
    }

    override fun getTransportType() = DeliveryType.AIR
}

fun scheduleDelivery(deliveryType: DeliveryType): Transport {
    return when (deliveryType) {
        DeliveryType.ROAD -> Truck()
        DeliveryType.AIR -> Air()
    }
}

fun main() {
    val delivery = scheduleDelivery(DeliveryType.ROAD)
    println(delivery.planDelivery())
}