package com.tzavellas.sse.sentiment

case class Sentiment(
  score: Int,
  numberOfWords: Int,
  positiveWords: Set[String],
  negativeWords: Set[String]) {

  def comparative: Float = score.toFloat / numberOfWords
}