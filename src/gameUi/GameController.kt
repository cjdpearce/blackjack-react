@file:Suppress("UnsafeCastFromDynamic")
package com.cjdpearce.blackjack

import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import react.RBuilder
import kotlinext.js.js
import react.dom.*
import kotlin.browser.document

fun RBuilder.GameController() {
    var gamestate =""
    if (playerHand.returnTotal()>21){
        gamestate="Sorry you lose!!"
    }else if (playerHand.getEndgame() && playerHand.returnTotal()<=21 && playerHand.returnTotal() > dealerHand.returnTotal()){
        gamestate="Congrats you win!!! Happy Days "
    }else if(playerHand.getEndgame() && playerHand.returnTotal()<=21 && playerHand.returnTotal() <= dealerHand.returnTotal() && dealerHand.returnTotal()<21){
        gamestate="Sorry the dealer wins, you lose"
    }else if(playerHand.getEndgame() && playerHand.returnTotal()<=21 && playerHand.returnTotal() <= dealerHand.returnTotal() && dealerHand.returnTotal()>21){
        gamestate="Congrats you win!!! Happy Days  "
    }else if( playerHand.returnTotal()==21){
        gamestate="Congrats you win!!! Happy Days "
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

            button {
            +"Twist"
                attrs.onClickFunction = {
                    playerHand.addCard(cardDeck.getCard())
                    console.log(playerHand.cardHand.size)
                    renderStuff()
                }
            }
            button {
                +"Stick"
                attrs.onClickFunction = {
                    playerHand.setEndgame(true)
                    while (dealerHand.returnTotal() < 17) {
                        dealerHand.addCard(cardDeck.getCard())
                    }
                    renderStuff()
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


