class HandStrength {

    var boardCardsStringList : MutableList<String> = mutableListOf()

    init {
        putCombosInBoardCards("AA")
        putCombosInBoardCards("KK")
        putCombosInBoardCards("QQ")
        putCombosInBoardCards("AKs")
        putCombosInBoardCards("JJ")
        putCombosInBoardCards("AKo")
        putCombosInBoardCards("AQs")
        putCombosInBoardCards("TT")
        putCombosInBoardCards("AJs")
        putCombosInBoardCards("AQo")
        putCombosInBoardCards("KQs")
        putCombosInBoardCards("ATs")
        putCombosInBoardCards("KJs")
        putCombosInBoardCards("99")
        putCombosInBoardCards("KTs")
        putCombosInBoardCards("QJs")
        putCombosInBoardCards("88")
        putCombosInBoardCards("QTs")
        putCombosInBoardCards("JTs")
        putCombosInBoardCards("A9s")
        putCombosInBoardCards("AJo")
        putCombosInBoardCards("KQo")
        putCombosInBoardCards("77")
        putCombosInBoardCards("K9s")
        putCombosInBoardCards("ATo")
        putCombosInBoardCards("A8s")
        putCombosInBoardCards("T9s")
        putCombosInBoardCards("66")
        putCombosInBoardCards("A7s")
        putCombosInBoardCards("55")
        putCombosInBoardCards("A5s")
        putCombosInBoardCards("A6s")
        putCombosInBoardCards("A4s")
        putCombosInBoardCards("J9s")
        putCombosInBoardCards("KJo")
        putCombosInBoardCards("Q9s")
        putCombosInBoardCards("44")
        putCombosInBoardCards("A3s")
        putCombosInBoardCards("KTo")
        putCombosInBoardCards("K8s")
        putCombosInBoardCards("A2s")
        putCombosInBoardCards("T8s")
        putCombosInBoardCards("98s")
        putCombosInBoardCards("QJo")
        putCombosInBoardCards("A9o")
        putCombosInBoardCards("QTo")
        putCombosInBoardCards("33")
        putCombosInBoardCards("K7s")
        putCombosInBoardCards("K6s")
        putCombosInBoardCards("Q8s")
        putCombosInBoardCards("K5s")
        putCombosInBoardCards("87s")
        putCombosInBoardCards("97s")
        putCombosInBoardCards("J8s")
        putCombosInBoardCards("87s")
        putCombosInBoardCards("76s")
        putCombosInBoardCards("65s")
        putCombosInBoardCards("JTo")
        putCombosInBoardCards("T7s")
        putCombosInBoardCards("86s")
        putCombosInBoardCards("A8o")
        putCombosInBoardCards("K4s")
        putCombosInBoardCards("96s")
        putCombosInBoardCards("Q7s")
        putCombosInBoardCards("Q6s")
        putCombosInBoardCards("T9o")
        putCombosInBoardCards("J7s")
        putCombosInBoardCards("K3s")
        putCombosInBoardCards("75s")
        putCombosInBoardCards("K9o")
        putCombosInBoardCards("T6s")
        putCombosInBoardCards("Q5s")
        putCombosInBoardCards("Q9o")
        putCombosInBoardCards("J9o")
        putCombosInBoardCards("A7o")
        putCombosInBoardCards("K2s")
        putCombosInBoardCards("64s")
        putCombosInBoardCards("A5o")
        putCombosInBoardCards("J6s")
        putCombosInBoardCards("85s")
        putCombosInBoardCards("22")
        putCombosInBoardCards("T5s")
        putCombosInBoardCards("J5s")
        putCombosInBoardCards("Q4s")
        putCombosInBoardCards("T8o")
        putCombosInBoardCards("98o")
        putCombosInBoardCards("A4o")
        putCombosInBoardCards("95s")
        putCombosInBoardCards("Q3s")
        putCombosInBoardCards("54s")
        putCombosInBoardCards("T5s")
        putCombosInBoardCards("J5s")
        putCombosInBoardCards("Q4s")
        putCombosInBoardCards("T8o")
        putCombosInBoardCards("98o")
        putCombosInBoardCards("A4o")
        putCombosInBoardCards("95s")
        putCombosInBoardCards("Q3s")
        putCombosInBoardCards("43s")
        putCombosInBoardCards("53s")
    }

    private fun putCombosInBoardCards(handString : String) {
        val comboOfHands = when {
            handString.length == 2 -> 4
            handString.contains("o") -> 12
            handString.contains("s") -> 6
            else -> -1
        }

        for(i in 0 until comboOfHands) {
            boardCardsStringList.add(handString)
        }

    }

    override fun toString(): String {
        return boardCardsStringList.toString()
    }
}
