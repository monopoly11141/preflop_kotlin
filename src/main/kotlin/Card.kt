/**
 * isSameCard() is not needed. use == to compare.
 *  CardA == CardB -> returns true if value and suit of A and B are same, otherwise false.
 *
 * toString() is not needed. It would return ex.) "Card(value=7, suit=s)" automatically.
 */

data class Card(
    var value: Char = '0',
    var suit: Char = '0'
) {
    constructor(cardString: String) : this() {
        this.value = cardString.first()
        this.suit = cardString.last()
    }

    fun getCardValue(): Int {
        return when (value) {
            in '2'..'9' -> Character.getNumericValue(value)
            'T' -> 10
            'J' -> 11
            'Q' -> 12
            'K' -> 13
            'A' -> 14
            else -> -1
        }
    }

    fun getCardValueDifference(otherCard: Card): Int {
        return this.getCardValue() - otherCard.getCardValue()
    }

}
