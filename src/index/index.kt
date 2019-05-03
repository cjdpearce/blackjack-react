@file:Suppress("UnsafeCastFromDynamic")

package com.cjdpearce.blackjack
import kotlinx.html.DIV
import kotlinx.html.style
import react.dom.*
import kotlin.browser.document
import kotlinext.js.js

var cardDeck = com.cjdpearce.blackjack.CardDeck()
var playerHand = com.cjdpearce.blackjack.CardHand()
var dealerHand = com.cjdpearce.blackjack.CardHand()

fun main(args: Array<String>) {
    val rootDiv=document.getElementById("root")
    init()
    render(rootDiv) {
        div {
                attrs.style = js {
                background="green"
                color="white"
                fontSize = "25px"
                    marginBottom="20px"
                    padding="10px"
            }
            div {
                h1 {
                    +"Blackjack"
                }
            }
            div {
                handUi(playerHand,"Player")
                handUi(dealerHand,"Dealer")
            }
        }

    }
}

fun init(){
    for (i in 1..2) {
        playerHand.addCard(cardDeck.getCard())
        dealerHand.addCard(cardDeck.getCard())
    }
}