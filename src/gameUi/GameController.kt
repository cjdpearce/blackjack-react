@file:Suppress("UnsafeCastFromDynamic")
package com.cjdpearce.blackjack

import kotlinext.js.js
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import react.RBuilder
import react.dom.*
import kotlin.browser.document


fun RBuilder.GameController() {
    var gamestate ="So, Would you like to Stick or Twist?"
        when {
            playerHand.returnTotal() == 21 -> gamestate="Congratulations you have a blackjack!"
            playerHand.returnTotal() > 21 -> gamestate="Sorry you've gone bust, better luck next time"
            dealerHand.returnTotal() > 21 -> gamestate="Dealer has gone bust, you win!"
            playerHand.getEndgame() && playerHand.returnTotal() > dealerHand.returnTotal() -> gamestate = "Congratulations you win!"
            playerHand.getEndgame() && playerHand.returnTotal() == dealerHand.returnTotal() -> gamestate = "Its a tie! Unbelievable Jeff"
            playerHand.getEndgame() && playerHand.returnTotal() < dealerHand.returnTotal() -> gamestate = "Sorry you lose, Better luck next time"
        }


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
            handUi(playerHand, "Player")
            handUi(dealerHand,"Dealer")
        }
        div {
            div{
                h3{
                    +gamestate
                }

            }

            if(gamestate == "So, Would you like to Stick or Twist?") {
                button {
                    +"Stick"
                    attrs.onClickFunction = {
                        playerHand.setEndgame(true)
                        while (dealerHand.returnTotal() < 17) {
                            dealerHand.addCard(cardDeck.getCard())
                        }
                        renderStuff()
                    }
                    attrs.style=js{
                        width = "160px"
                        height = "40px"
                        margin = "20px"
                    }
                }
                button {
                    +"Twist"
                    attrs.onClickFunction = {
                        playerHand.addCard(cardDeck.getCard())
                        console.log(playerHand.cardHand.size)
                        for (card in playerHand.cardHand) {
                            if (card.key.contains("A") && playerHand.returnTotal() > 21) {
                                card.setValue("1")
                                if (playerHand.returnTotal() < 21) {
                                    break
                                }
                            }
                        }
                        renderStuff()
                    }
                    attrs.style=js{
                        width = "160px"
                        height = "40px"
                        margin = "20px"
                    }
                }
            }else{
                button {
                    +"Restart"
                    attrs.onClickFunction = {
                       js("location.reload();")
                    }
                    attrs.style=js{
                        width = "160px"
                        height = "40px"
                    }
                }

            }

    }

    }

}

fun renderStuff(){
    val rootDiv = document.getElementById("root")
    render(rootDiv){
        GameController()
    }
}


