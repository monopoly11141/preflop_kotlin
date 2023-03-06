import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import utils.CardUtils

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PairFinderTest {
    private lateinit var hand7s7d: Hand
    private lateinit var hand8s7s: Hand
    private lateinit var handAsAd: Hand
    private lateinit var handAs5d: Hand
    private lateinit var hand8c8h: Hand

    private lateinit var board8c8h8d: Board

    private lateinit var board88822: Board
    private lateinit var board88722: Board
    private lateinit var pairFinder : PairFinder
    private lateinit var handList : MutableList<Card>
    val cardMap = mutableMapOf<String, Card>()

    @BeforeAll
    fun beforeAll() {
        for(value in CardUtils.values) {
            for(suit in CardUtils.suits) {
                cardMap["$value$suit"] = Card("$value$suit")
            }
        }

    }
    @BeforeEach
    fun beforeEach() {
        hand7s7d = Hand(mutableListOf(cardMap["7s"]!!, cardMap["7d"]!!))
        hand8s7s = Hand(mutableListOf(cardMap["8s"]!!, cardMap["7s"]!!))
        handAsAd = Hand(mutableListOf(cardMap["As"]!!, cardMap["Ad"]!!))
        handAs5d = Hand(mutableListOf(cardMap["As"]!!, cardMap["5d"]!!))
        hand8c8h = Hand(mutableListOf(cardMap["8c"]!!, cardMap["8h"]!!))
        board8c8h8d = Board(mutableListOf(cardMap["8c"]!!, cardMap["8h"]!!, cardMap["8d"]!!))

        board88822 = Board(mutableListOf(Card("8s"), Card("8d"), Card("8c"), Card("2s"), Card("2d")))
        board88722 = Board(mutableListOf(Card("7c"), Card("8d"), Card("8s"), Card("2s"), Card("2d")))
        handList = mutableListOf()
    }
    @Test
    fun returnBestFive() {

        /**
         * quads
         */
        //board 888 , hero 8x
        pairFinder = PairFinder(hand8s7s, board8c8h8d)
        assertEquals("quads", pairFinder.handRankingString)
        handList = mutableListOf(Card("8c"), Card("8h"), Card("8d"), Card("8s"), Card("7s"))
        assertTrue(pairFinder.returnBestFive().containsAll(handList))

    }

    @Test
    fun returnHandRanking() {
    }
}