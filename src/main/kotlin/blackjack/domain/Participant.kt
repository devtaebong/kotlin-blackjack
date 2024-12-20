package blackjack.domain

sealed class Participant(
    val name: String = "Unknown",
    val ownedCards: MutableList<Card> = mutableListOf(),
    private val actions: MutableList<HitCommand> = mutableListOf(),
) {
    fun receiveCard(card: Card) {
        ownedCards.add(card)
        actions.add(HitCommand.HIT)
    }

    fun stay() {
        actions.add(HitCommand.STAY)
    }

    fun hasBusted(): Boolean {
        return sumOfCard() <= 21
    }

    fun hasStayed(): Boolean {
        return actions.lastOrNull() == HitCommand.STAY
    }

    fun sumOfCard(): Int {
        var totalSum = 0
        ownedCards.forEach {
            totalSum += it.number.appendScore(totalSum)
        }
        return totalSum
    }

    fun clearOwnedCards() {
        ownedCards.clear()
    }

    class Player(name: String, bettingAmount: Int = 0, ownedCards: MutableList<Card> = mutableListOf()) : Participant(
        name = name,
        ownedCards = ownedCards,
    )

    class Dealer(
        private val deck: Deck,
    ) : Participant() {
        fun deal(participants: Participants) {
            repeat(NUMBER_OF_DEAL_CARD) {
                dealOneCardToEachPlayer(participants)
            }
        }

        private fun dealOneCardToEachPlayer(participants: Participants) {
            participants.allPlayers().forEach {
                it.receiveCard(deck.draw())
            }
        }

        fun giveCardTo(participant: Participant) {
            participant.receiveCard(deck.draw())
        }

        fun shouldDrawCard(): Boolean = sumOfCard() <= DRAW_LIMIT

        companion object {
            private const val NUMBER_OF_DEAL_CARD = 2
            private const val DRAW_LIMIT: Int = 16
        }
    }
}
