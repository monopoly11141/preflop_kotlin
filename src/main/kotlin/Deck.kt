import utils.CardUtils

class Deck() {
    val cardDeck : MutableList<Card> = mutableListOf()

    init {
        newDeck()
        shuffleCardDeck()
    }

    private fun newDeck() {
        cardDeck.clear()

        for(value in CardUtils.values) {
            for(suit in CardUtils.suits) {
                cardDeck.add(Card("${value}${suit}"))
            }
        }

    }

    fun shuffleCardDeck() {
        cardDeck.shuffle()
    }

    fun dealHand(): Hand {

        val hand : MutableList<Card> = mutableListOf()

        hand.add(getOneCard())
        hand.add(getOneCard())

        return Hand(hand)
    }

    fun getOneCard(): Card {
        return cardDeck.removeAt(cardDeck.size - 1)
    }
}