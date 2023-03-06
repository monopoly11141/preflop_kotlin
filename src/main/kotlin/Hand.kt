data class Hand(
    var hand: MutableList<Card> = mutableListOf(),
    var handType: String = ""

) {
    constructor(cards: String) : this() {
        hand.add(0, Card(cards.substring(0..1)))
        hand.add(1, Card(cards.substring(2)))

        initHandType()
    }

    constructor(cards : MutableList<Card>) : this() {
        hand = cards

        initHandType()
    }

    private fun initHandType() {
        val firstCard = hand[0]
        val secondCard = hand[1]

        val diffInCardValue = firstCard.getCardValueDifference(secondCard)

        handType += firstCard.value

        handType = when {
            diffInCardValue > 0 -> "${handType}${secondCard.value}"
            diffInCardValue < 0 -> "${secondCard.value}${handType}"
            else -> "${handType}${secondCard.value}"
        }

        val isSuited = (firstCard.suit == secondCard.suit)

        if (diffInCardValue != 0) {
            handType = if (isSuited) handType + "s" else handType + "o"
        }
    }
}
