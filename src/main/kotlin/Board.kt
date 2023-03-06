class Board(cards: MutableList<Card>) {

    var boardCards : MutableList<Card> = cards

    fun addCard(newCard : Card) {
        boardCards.add(newCard)
    }

    override fun toString() : String {
        var infoString = ""
        for(cards in boardCards) {
            infoString = "${infoString} | ${cards}"
        }
        return infoString
    }

}