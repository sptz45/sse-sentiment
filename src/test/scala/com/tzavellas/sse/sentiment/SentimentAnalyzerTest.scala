package com.tzavellas.sse.sentiment

import org.junit.Test
import org.junit.Assert._

class SentimentAnalyzerTest {

  val wordList = new WordList(Map("good" -> 3, "bad" -> -3, "ugly" -> -5))
  val analyzer = new SentimentAnalyzer(wordList)

  @Test
  def should_analyze_sentiment(): Unit = {
    val s = analyzer.sentimentOf("The good, the bad and the ugly")
    assertEquals(-5, s.score)
    assertEquals(Set("good"), s.positiveWords)
    assertEquals(Set("bad", "ugly"), s.negativeWords)
    assertEquals(7, s.numberOfWords)
  }

  @Test
  def should_handle_negation(): Unit = {
    val s = analyzer.sentimentOf("This is not good")
    assertEquals(-3, s.score)
    assertEquals(Set("good"), s.negativeWords)
    assertEquals(4, s.numberOfWords)
  }
}