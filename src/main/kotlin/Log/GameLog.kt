package Log

import Log.Log

data class GameLog(
    val historyLogList : MutableList<Log> = mutableListOf()
)