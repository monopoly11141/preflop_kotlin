import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CardTest {
    private lateinit var card7s : Card
    private lateinit var card7sSame : Card
    private lateinit var cardKd : Card

    @BeforeEach
    fun beforeEach() {
        card7s = Card("7s")
        card7sSame = Card("7s")
        cardKd = Card("Kd")
    }

    @Test
    fun getCardValue() {
        assertEquals(7, card7s.getCardValue())
        assertEquals(13, cardKd.getCardValue())
    }

    @Test
    fun getCardValueDifference() {
        assertEquals(0, card7s.getCardValueDifference(card7sSame))
        assertEquals(-6, card7s.getCardValueDifference(cardKd))
    }

    @Test
    fun testToString() {
        assertEquals("Card(value=7, suit=s)", card7s.toString())
        assertEquals("Card(value=K, suit=d)", cardKd.toString())
    }
}