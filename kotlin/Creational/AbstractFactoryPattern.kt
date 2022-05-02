interface Chair {
    fun hasLegs(): Boolean
    fun sitOn(): String
}

interface CofeeTable {
    fun hasLegs(): Boolean
    fun changeColor(): String
}

interface Sofa {
    fun size(): Int
}

class VictorianChair : Chair {
    override fun hasLegs(): Boolean {
        return true
    }

    override fun sitOn(): String {
        return "Inside sitOn() function"
    }
}

class ModernChair : Chair {
    override fun hasLegs(): Boolean {
        return true
    }

    override fun sitOn(): String {
        return "Inside sitOn() function"
    }
}


interface FurnitureFactory {
    fun createChair(): Chair
    fun createCofeeTable(): CofeeTable
    fun createSofa(): Sofa
}


class VictorianFurnitureFactory : FurnitureFactory {
    override fun createChair(): Chair {
        return VictorianChair()
    }

    override fun createCofeeTable(): CofeeTable {
        TODO("Not yet implemented")
    }

    override fun createSofa(): Sofa {
        TODO("Not yet implemented")
    }
}

class ModernFurnitureFactory : FurnitureFactory {
    override fun createChair(): Chair {
        return ModernChair()
    }

    override fun createCofeeTable(): CofeeTable {
        TODO("Not yet implemented")
    }

    override fun createSofa(): Sofa {
        TODO("Not yet implemented")
    }
}