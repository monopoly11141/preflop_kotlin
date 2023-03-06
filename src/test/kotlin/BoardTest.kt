import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BoardTest {

    lateinit var board: Board
    lateinit var card7s: Card
    lateinit var cardKd: Card
    lateinit var cardsMutableList: MutableList<Card>

    @BeforeEach
    fun beforeEach() {
        card7s = Card("7s")
        cardKd = Card("Kd")

        cardsMutableList = mutableListOf()
        cardsMutableList.add(card7s)

        board = Board(cardsMutableList)
    }

    @Test
    fun addCard() {
        assertTrue(board.boardCards[0] == card7s)
        board.addCard(cardKd)
        assertTrue(board.boardCards[1] == cardKd)
    }

    @Test
    fun testToString() {
        assertEquals(" | Card(value=7, suit=s)", board.toString())
        board.addCard(cardKd)
        assertEquals(" | Card(value=7, suit=s) | Card(value=K, suit=d)", board.toString())
    }
}