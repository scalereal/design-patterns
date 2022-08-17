interface File {
    fun read()
}

class NormalFile(val name: String) : File {
    override fun read() = println("Reading file: $name")
}

//Proxy:
class SecuredFile(val name: String) : File {
    val normalFile = NormalFile(name)
    var password: String = ""

    override fun read() {
        if (password == "secret") {
            println("Password is correct: $password")
            normalFile.read()
        } else {
            println("Incorrect password. Access denied!")
        }
    }
}

fun main(args: Array<String>) {
    val securedFile = SecuredFile("readme.md")
    securedFile.read()

    securedFile.password = "secret"
    securedFile.read()
}