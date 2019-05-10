@file:Suppress("UnsafeCastFromDynamic")

package com.cjdpearce.blackjack
import kotlinx.html.DIV
import kotlinx.html.style
import react.dom.*
import kotlin.browser.document
import kotlinext.js.js
import kotlinx.html.js.onClickFunction


var cardDeck = com.cjdpearce.blackjack.CardDeck()
var playerHand = com.cjdpearce.blackjack.CardHand()
var dealerHand = com.cjdpearce.blackjack.CardHand()

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