package com.cjdpearce.blackjack

class CardDeck {
    private var cardDeck: MutableMap<String, String> = mutableMapOf()
    private var cards: MutableList<String> = mutableListOf()

    init {
        buildDeck()
        shuffleDeck()
    }

    private fun buildDeck() {
        var suits: ArrayList<String> = arrayListOf("Hearts", "Clubs", "Diamonds", "Spades")
        for (suit in suits) {
            for (i in 2..10) {
                cardDeck[suit + i] = i.toString()
            }
            cardDeck[suit + "Jack"] = "10"
            cardDeck[suit + "Queen"] = "10"
            cardDeck[suit + "King"] = "10"
            cardDeck[suit + "Ace"] = "11"
        }
    }

    private fun shuffleDeck(): List<String> {
        cards = cardDeck.keys.shuffled().toMutableList()
        return cards
    }

    fun getCard(): String {
        val card = cards.first()
        cards.removeAt(0)
        return card
    }

    fun getCardValue(card: String): String {
        return cardDeck[card].toString()
    }
}