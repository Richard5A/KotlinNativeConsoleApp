abstract class Command {
    abstract fun execute(args: List<String>)
    abstract val commandName: String
    abstract val description: String?
}
