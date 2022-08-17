import java.io.IOException
import java.io.FileReader
import java.io.FileOutputStream
import java.io.OutputStream

interface DataSource {
    fun writeData(data: String)
    fun readData(): String
}

class FileDataSource(private val name: String) : DataSource {
    override fun writeData(data: String) {
        val file = File(name)
        try {
            FileOutputStream(file).use { fos -> fos.write(data.toByteArray(), 0, data.length) }
        } catch (ex: IOException) {
            println(ex.message)
        }
    }

    override fun readData(): String {
        var buffer: CharArray? = null
        val file = File(name)
        try {
            FileReader(file).use { reader ->
                buffer = CharArray(file.length() as Int)
                reader.read(buffer)
            }
        } catch (ex: IOException) {
            println(ex.message)
        }
        return String(buffer)
    }
}

class DataSourceDecorator internal constructor(private val wrappee: DataSource) : DataSource {
    fun writeData(data: String?) {
        wrappee.writeData(data!!)
    }

    override fun readData(): String {
        return wrappee.readData()
    }
}

class EncryptionDecorator(source: DataSource?) : DataSourceDecorator(source!!) {
    override fun writeData(data: String) {
        super.writeData(encode(data))
    }

    override fun readData(): String {
        return decode(super.readData())
    }

    private fun encode(data: String): String {
        val result: ByteArray = data.toByteArray()
        for (i in result.indices) {
            (result[i] += 1.toByte()).toByte()
        }
        return Base64.getEncoder().encodeToString(result)
    }

    private fun decode(data: String): String {
        val result: ByteArray = Base64.getDecoder().decode(data)
        for (i in result.indices) {
            (result[i] -= 1.toByte()).toByte()
        }
        return String(result)
    }
}