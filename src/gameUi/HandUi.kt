@file:Suppress("UnsafeCastFromDynamic")

package com.cjdpearce.blackjack

import kotlinext.js.js
import kotlinx.html.DIV
import kotlinx.html.style
import org.w3c.dom.Image
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.h2
import react.dom.img

@JsModule("src/Cards/cardClubs2.png")
external val logo: dynamic

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
                        }
                        div {
                            var image = Image()
                            image.src= logo
                            img(src = image.src){}


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