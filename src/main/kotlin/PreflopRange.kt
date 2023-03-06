class PreflopRange {
    private val rfiRanges = doubleArrayOf(.40, .53, .62, 1.0, .85)
    private val handStrength = HandStrength()
    private var currPosition = 0
    private lateinit var log: GameLog

    constructor(log: GameLog, pos: Int) {
        this.log = log
        this.currPosition = pos
    }

    fun getContinuingRange(): Int {
        val positionsRaised: ArrayList<Int> = getPositionsRaised(log)
        val numRaises = positionsRaised.size

        return when {
            log.historyLogList.size < 5 -> getRaiseRange(positionsRaised)
            log.historyLogList.size == 5 -> bigBlindReaction(positionsRaised)
            else ->
                when (numRaises) {
                    2 -> facingThreeBet()
                    3 -> facingFourBet()
                    else -> 26
                }
        }
    }

    fun RFI(pos: Int): Int {
        return (handStrength.boardCardsStringList.size * rfiRanges[pos]).toInt()
    }

    // returns a integer amount of the strongest x number of hands to play.
    fun getRaiseRange(positionsRaised: ArrayList<Int>): Int {
        return when (positionsRaised.size) {
            0 -> RFI(currPosition)
            1 -> threeBet(positionsRaised)
            2 -> (threeBet(positionsRaised) * .35).toInt()
            else -> 20
        }

    }

    // get the position that raised and raised 45% of the hands that they raised
    // * need to change sb as it should be tighter than other positions
    fun threeBet(positions: ArrayList<Int>): Int {
        return (RFI(positions[0]) * .35).toInt()
    }

    // decision making when facing a 3!
    // *need to implement different frequencies when IP and OOP
    fun facingThreeBet(): Int {
        val positionsRaised: ArrayList<Int> = getPositionsRaised(log)
        val rfi = RFI(positionsRaised[0])
        val raising = (rfi * .13).toInt()
        val calling = raising + (rfi * .25).toInt()

        return (calling * .80).toInt()
    }

    // decision making when facing a 4!
    fun facingFourBet(): Int {
        return 45
    }

    // gets the positions that have raised
    private fun getPositionsRaised(log: GameLog): ArrayList<Int> {
        val positionsRaised = java.util.ArrayList<Int>()
        for (x in 0 until log.historyLogList.size) {
            if (log.historyLogList[x].actionTaken == "r") {
                positionsRaised.add(x)
            }
        }
        return positionsRaised
    }

    // return a integer amount of number of continuing hands
    // * need to fix the bu vs bb continuing range as it is not defending wide
    // enough vs bu opens
    fun bigBlindReaction(action: ArrayList<Int>): Int {
        return when (action.size) {
            1 -> if (action[0] == 3 || action[0] == 4) {
                RFI(action[0])
            } else {
                (RFI(action[0]) * 1.3).toInt()
            }
            2 -> (threeBet(action) * .4).toInt()
            else -> 26
        }
    }

}