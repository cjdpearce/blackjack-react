@file:Suppress("UnsafeCastFromDynamic")

package com.cjdpearce.blackjack
import react.dom.*
import kotlin.browser.document

var cardDeck = CardDeck()
var playerHand = CardHand()
var dealerHand = CardHand()

fun main(args: Array<String>) {
    val rootDiv = document.getElementById("root")
    init()
    render(rootDiv) {
        GameController()
    }

}

fun init() {
    for (i in 1..2) {
        playerHand.addCard(cardDeck.getCard())
        dealerHand.addCard(cardDeck.getCard())
    }
}