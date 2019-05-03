package com.cjdpearce.blackjack

import kotlinx.html.DIV
import kotlinx.html.style
import react.dom.RDOMBuilder
import react.dom.b
import react.dom.div
import react.dom.h2

fun RDOMBuilder<DIV>.handUi(ch:CardHand,playerName:String) {
    div {
        h2 { +playerName
            attrs.style = kotlinext.js.js {
                alignment="center"
                fontSize = "30px"
            }}
        div{
            attrs.style = kotlinext.js.js{
                display="flex"
            }
            div {
                attrs.style = kotlinext.js.js {
                    padding = "20px"
                    width = "200px"
                    height="320px"
                    marginRight="20px"
                    marginLeft="20px"
                    marginBottom="20px"
                    background="white"
                    fontSize = "20px"
                    color="black"
                }
                div { +ch.returnPretty()[0]}
            }
            div {
                attrs.style = kotlinext.js.js {
                    padding = "20px"
                    width = "200px"
                    height = "320px"
                    marginRight = "20px"
                    marginLeft = "20px"
                    marginBottom = "20px"
                    background = "white"
                    fontSize = "20px"
                    color = "black"
                }
                div { +ch.returnPretty()[1]}
            }

        }
        div {+"Total: "
            +ch.returnTotal().toString() }
    }
}