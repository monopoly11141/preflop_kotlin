import java.util.*

class PairFinder {
    val allCards: MutableList<Card> = mutableListOf()
    val cardListArrayList: MutableList<CardList> = mutableListOf()
    val cardPairArray = intArrayOf(0, 0, 0, 0)
    var handRankingString: String = ""

    constructor(hand: Hand, board: Board) {
        allCards.addAll(hand.hand)
        allCards.addAll(board.boardCards)
        for (i in 0..3) {
            cardListArrayList.add(CardList())
        }
        doCalculation()
        initHandRankingString()
    }

    private fun doCalculation() {
        val deepCopyOfAllCards = mutableListOf<Card>()
        deepCopyOfAllCards.addAll(allCards)

        val significantCardArrayList = mutableListOf<Card>()

        var count = 0
        while (deepCopyOfAllCards.size != 0) {
            significantCardArrayList.clear()
            count = 0
            val thisCard = deepCopyOfAllCards.removeAt(0)
            significantCardArrayList.add(thisCard)
            var i = 0
            while (i < deepCopyOfAllCards.size) {
                if (thisCard.value == deepCopyOfAllCards[i].value) {
                    count++
                    significantCardArrayList.add(deepCopyOfAllCards[i])
                    deepCopyOfAllCards.remove(deepCopyOfAllCards[i])
                    i--
                }
                i++
            }
            cardPairArray[count]++
            for (card in significantCardArrayList) {
                cardListArrayList[count].cardList.add(card)
            }
            for (cardList in cardListArrayList) {
                sortListWithout(cardList.cardList, ArrayList<Card>())
            }
        }
    }

    fun returnBestFive(): MutableList<Card> {
        if (handRankingString == "quads") {
            val fiveCard: MutableList<Card> = cardListArrayList[3].cardList
            val sortedCards: MutableList<Card> = sortListWithout(allCards, fiveCard)
            fiveCard.add(sortedCards[0])
            return fiveCard
        } else if (handRankingString == "full house" || handRankingString == "trips") {
            val fiveCard: MutableList<Card> = mutableListOf()
            // {trips + a}
            for (i in 0..2) {
                fiveCard.add(cardListArrayList[2].cardList[i])
            }
            var isDoubleTrips = false
            // {fullhouse -> trips + trips}
            for (i in 3 until cardListArrayList[2].cardList.size) {
                isDoubleTrips = true
                fiveCard.add(cardListArrayList[2].cardList[i])
                if (fiveCard.size == 5) {
                    break
                }
            }
            var isFullHouse = false
            // {full house -> trips + pair}
            if (!isDoubleTrips) {
                for (i in 0 until cardListArrayList[1].cardList.size) {
                    isFullHouse = true
                    fiveCard.add(cardListArrayList[1].cardList[i])
                    if (fiveCard.size == 5) {
                        break
                    }
                }
            }
            // {trips}
            if (!isFullHouse) {
                if (fiveCard.size != 5) {
                    val sortedCards: MutableList<Card> = sortListWithout(allCards, fiveCard)
                    fiveCard.add(sortedCards[0])
                    fiveCard.add(sortedCards[1])
                }
            }
            return fiveCard
        } else if (handRankingString == "two pair" || handRankingString == "one pair") {
            val fiveCard = ArrayList<Card>()
            for (i in 0 until cardListArrayList[1].cardList.size) {
                fiveCard.add(cardListArrayList[1].cardList[i])
                if (fiveCard.size == 4) {
                    break
                }
            }
            val sortedCards: MutableList<Card> = sortListWithout(allCards, fiveCard)
            val fiveCardCurrentSize = fiveCard.size
            for (i in 0 until 5 - fiveCardCurrentSize) {
                fiveCard.add(sortedCards[i])
            }
            return fiveCard
        } else {
            val fiveCard: MutableList<Card> = mutableListOf()
            val sortedCards: MutableList<Card> = sortListWithout(allCards, ArrayList<Card>())
            for (i in 0..4) {
                fiveCard.add(sortedCards[i])
            }
            return fiveCard
        }
    }

    fun initHandRankingString(): String {
        handRankingString = if (cardPairArray[3] == 1) {
            "quads"
        } else if (cardPairArray[2] >= 1) {
            if (cardPairArray[1] >= 1 || cardPairArray[2] >= 2) {
                "full house"
            } else {
                "trips"
            }
        } else if (cardPairArray[1] >= 2) {
            "two pair"
        } else if (cardPairArray[1] >= 1) {
            "one pair"
        } else {
            "no pair"
        }

        return handRankingString
    }

    private fun sortListWithout(toBeSorted: MutableList<Card>, withoutCards: MutableList<Card>): MutableList<Card> {
        for (card in withoutCards) {
            toBeSorted.remove(card)
        }
        val n = toBeSorted.size
        val cardValues = charArrayOf('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')

        for (i in 0 until n) {
            for (j in 1 until n - i) {
                val indexFirstCard = cardValues.indexOf(toBeSorted[j - 1].value)
                val indexSecondCard = cardValues.indexOf(toBeSorted[j].value)

                if (indexFirstCard < indexSecondCard) {
                    toBeSorted[j].also { toBeSorted[i] = toBeSorted[j] }

                }
            }
        }
        return toBeSorted
    }
}