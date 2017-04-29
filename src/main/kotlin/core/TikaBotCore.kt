package core

import com.google.common.util.concurrent.FutureCallback
import de.btobastian.javacord.DiscordAPI
import de.btobastian.javacord.Javacord
import de.btobastian.javacord.listener.message.MessageCreateListener

/**
 * Created by alewis on 29/04/2017.
 */
class TikaBotCore(token: String) {

    val discordApi: DiscordAPI = Javacord.getApi(token, true)

    fun connect() {
        discordApi.connect(object : FutureCallback<DiscordAPI> {

            override fun onSuccess(api: DiscordAPI?) {
                // register listener
                api?.registerListener(MessageCreateListener { api, message ->
                    // check the content of the message
                    if (message.content.equals("ping", true)) {
                        // reply to the message
                        message.reply("pong")
                    }
                })
            }

            override fun onFailure(t: Throwable) {
                t.printStackTrace()
            }
        })
    }
    
    fun setup() {
        registerChatListeners()
    }

    fun registerChatListeners() {
        discordApi.registerListener(MessageCreateListener { api, message ->
            println("New message from ${message.author} ${message.content}")
        })
    }
}