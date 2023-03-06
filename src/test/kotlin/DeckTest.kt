import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DeckTest {

    lateinit var deck : Deck

    @BeforeEach
    fun beforeEach() {
        deck = Deck()
    }

    @Test
    fun getCardDeck() {
        assertEquals(52, deck.cardDeck.size)
        deck.getOneCard()
        assertEquals(51, deck.cardDeck.size)
    }

    @Test
    fun dealHand() {
        val dealtHand = deck.dealHand()
        assertEquals(50, deck.cardDeck.size)
        assertFalse(dealtHand.hand[0] == dealtHand.hand[1])
    }
}