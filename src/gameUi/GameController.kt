@file:Suppress("UnsafeCastFromDynamic")
package com.cjdpearce.blackjack

import com.cjdpearce.blackjack.dealerHand
import com.cjdpearce.blackjack.handUi
import com.cjdpearce.blackjack.playerHand
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import react.RBuilder
import react.dom.button
import react.dom.div
import react.dom.h1
import react.dom.h2
import kotlinext.js.js

fun RBuilder.GameController() {
    div {
        attrs.style = js {
            background = "green"
            color = "white"
            fontSize = "25px"
            marginBottom = "20px"
            padding = "10px"
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
        div {
            button {
            +"Twist"
                attrs.onClickFunction = {
                    playerHand.addCard(cardDeck.getCard())
                    console.log(playerHand.cardHand.size)
                    GameController()
                }
            }
            button{ +"Stick"
                attrs.onClickFunction = {console.log("i is also clicked")}}

        }
    }
}


