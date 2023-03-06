class Deck() {
    val cardDeck : MutableList<Card> = mutableListOf()

    init {
        newDeck()
        shuffleCardDeck()
    }

    private fun newDeck() {
        cardDeck.clear()

        val values = charArrayOf('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')
        val suits = charArrayOf('c', 'd', 'h', 's')

        for(value in values) {
            for(suit in suits) {
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