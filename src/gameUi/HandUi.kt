@file:Suppress("UnsafeCastFromDynamic")

package com.cjdpearce.blackjack

import kotlinx.html.DIV
import kotlinx.html.style
import react.dom.RDOMBuilder
import react.dom.b
import react.dom.div
import react.dom.h2
import kotlinext.js.js

fun RDOMBuilder<DIV>.handUi(ch:CardHand,playerName:String) {
    div {
        h2 {
            +playerName
            attrs.style = js {
                alignment = "center"
                fontSize = "30px"
            }
        }
        div {
            attrs.style = js {
                display = "flex"
            }
            for (card in ch.returnPretty()) {
                console.log("playersHandSize: " + playerHand.cardHand.size)
                div {
                    attrs.style = js {
                        display = "flex"
                    }
                    div {
                        attrs.style = js {
                            padding = "20px"
                            width = "100px"
                            height = "160px"
                            marginRight = "20px"
                            marginLeft = "20px"
                            marginBottom = "20px"
                            background = "white"
                            fontSize = "20px"
                            color = "black"
                        }
                        div {
                            +card
                        }
                    }
                }
                if(playerName.toLowerCase() == "dealer" && !playerHand.getEndgame()){
                    break
                }
            }
        }
        if(playerName.toLowerCase() != "dealer" || playerHand.getEndgame()) {
            div {
                +"Total: "
                +ch.returnTotal().toString()
            }
        }

    }
}