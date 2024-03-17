import kotlin.system.exitProcess

fun main() {
    println("Hello, Kotlin/Native! How are you?")

    val consoleManager = ConsoleManager()
    consoleManager.addCommand(object : Command() {
        override val commandName = "echo"
        override val description = "Prints the input to the console"

        override fun execute(args: List<String>) {
            println(args.joinToString(" "))
        }
    })
    consoleManager.addCommand(object : Command() {
        override val commandName = "exit"
        override val description = "Exits the program"

        override fun execute(args: List<String>) {
            println("Goodbye!")
            exitProcess(0)
        }
    })
    consoleManager.addCommand(object : Command() {
        override val commandName = "ispalindrome"
        override val description = "Checks if the input is a palindrome"

        override fun execute(args: List<String>) {
            val input = args[0]
            val isPalindrome = input == input.reversed()
            println("Is \"$input\" a palindrome? $isPalindrome")
        }
    })

    consoleManager.start()
}