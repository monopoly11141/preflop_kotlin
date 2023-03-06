import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HandTest {

    private lateinit var hand77: Hand
    private lateinit var handK6: Hand
    private lateinit var hand6K: Hand
    private lateinit var handA7: Hand
    private lateinit var hand7A: Hand

    @BeforeEach
    fun beforeEach() {
        hand77 = Hand("7s7d")
        handK6 = Hand("Kc6d")
        hand6K = Hand("6dKc")
        handA7 = Hand("Ac7c")
        hand7A = Hand("7cAc")
    }


    @Test
    fun getHand() {
        assertEquals("Card(value=7, suit=s)", hand77.hand[0].toString())
        assertEquals("Card(value=7, suit=d)", hand77.hand[1].toString())
        assertEquals("Card(value=K, suit=c)", handK6.hand[0].toString())
        assertEquals("Card(value=6, suit=d)", handK6.hand[1].toString())
        assertEquals("Card(value=A, suit=c)", handA7.hand[0].toString())
        assertEquals("Card(value=7, suit=c)", handA7.hand[1].toString())
        assertEquals("Card(value=7, suit=c)", hand7A.hand[0].toString())
        assertEquals("Card(value=A, suit=c)", hand7A.hand[1].toString())
    }

    @Test
    fun getHandType() {
        assertEquals("77", hand77.handType)
        assertEquals("K6o", handK6.handType)
        assertEquals("K6o", hand6K.handType)
        assertEquals("A7s", handA7.handType)
        assertEquals("A7s", hand7A.handType)
    }

    @Test
    fun testToString() {
        assertEquals("Hand(hand=[Card(value=7, suit=s), Card(value=7, suit=d)], handType=77)", hand77.toString())
    }
}