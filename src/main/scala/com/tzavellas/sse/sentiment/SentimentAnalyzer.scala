package com.tzavellas.sse.sentiment

import scala.collection.mutable

class SentimentAnalyzer(wordlist: WordList) {

  private[this] val negators = Set("dont", "doesnt", "not", "non", "cant", "wont")

  def sentimentOf(phrase: String) = {    
    var score = 0
    val positive = new mutable.HashSet[String]
    val negative = new mutable.HashSet[String]

    val words = Tokenizer.tokenize(phrase)

    var isNegated = false
    for (word <- words) {
      var valence = wordlist.valenceOf(word)

      if (isNegated) {
        valence = -valence
        isNegated = false
      }

      score += valence

      if (valence > 0) {
        positive += word
      } else if (valence < 0) {
        negative += word
      }

      if (negators.contains(word)) {
        isNegated = !isNegated
      }
    }

    Sentiment(score, words.length, positive.toSet, negative.toSet)
  }
  
}