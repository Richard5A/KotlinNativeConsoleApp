import platform.windows.TRUE

class ConsoleManager {
    var commands = mutableListOf<Command>()

    constructor() {
        addCommand(object : Command() {
            override val commandName = "help"
            override val description = "Prints the available commands"

            override fun execute(args: List<String>) {
                println("Available commands")
                commands.forEach {
                    println(" - ${it.commandName} - ${it.description}")
                }
            }
        })
    }

    fun addCommand(command: Command) {
        commands.add(command)
    }

    fun removeCommand(command: Command) {
        commands.remove(command)
    }

    fun start() {
        println("ConsoleManager started")
        while (true) {
            print(" > ")
            val input = readlnOrNull() ?: continue

            val args = input.split(" ").toTypedArray()
            val commandName = args[0]
            val command = commands.find { it.commandName == commandName }
            if (command != null) {
                command.execute(args.drop(1))
            } else {
                println("Command not found, try again.")
                continue
            }

        }
    }
}