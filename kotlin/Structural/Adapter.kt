// 3rd party functionality

data class DisplayDataType(val index: Long, val data: String)

class DataDisplay {
    fun display(display: DisplayDataType) {
        println("Data:- ${display.index}-${display.data}")
    }
}

// Our code

data class DatabaseData(val position: Long, val amount: Double)

class DatabaseDataGenerator {
    fun generate(): List<DatabaseData> {
        val list = arrayListOf<DatabaseData>()

        list.add(DatabaseData(position = 1, amount = 200.0))
        list.add(DatabaseData(position = 2, amount = 400.0))

        return list
    }
}

interface DatabaseDataConverter {
    fun convertData(data: List<DatabaseData>): List<DisplayDataType>
}

class DisplayDataAdaptor(val dataDisplay: DataDisplay) : DatabaseDataConverter {
    override fun convertData(data: List<DatabaseData>): List<DisplayDataType> {
        val result = arrayListOf<DisplayDataType>()

        data.forEach {
            val ddt = DisplayDataType(index = it.position, data = it.amount.toString())
            dataDisplay.display(ddt)
            result.add(ddt)
        }

        return result
    }
}

fun main() {
    val generator = DatabaseDataGenerator()
    val generatedData = generator.generate()

    val adaptor = DisplayDataAdaptor(DataDisplay())

    adaptor.convertData(generatedData)
}

/* output
Data:- 1-200.0
Data:- 2-400.0
*/