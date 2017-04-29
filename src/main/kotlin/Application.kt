import core.TikaBotCore

/**
 * Created by alewis on 29/04/2017.
 */

fun main(args: Array<String>) {

    val tikaBotCore = TikaBotCore(args[0])
    tikaBotCore.connect()
    tikaBotCore.setup()
}
