package com.tzavellas.sse.sentiment

import org.junit.Test
import org.junit.Assert._

class WordListTest {

  val wl = new WordList(Map("good" -> 3))

  @Test
  def should_return_the_valence_of_a_word(): Unit = {
    assertEquals(3, wl.valenceOf("good"))
  }

  @Test
  def should_return_zero_for_words_not_in_list(): Unit = {
    assertEquals(0, wl.valenceOf("neutral"))
  }

  @Test
  def should_add_word_to_list(): Unit = {
    val augmented = wl + ("bad" -> -3)
    assertEquals(3, augmented.valenceOf("good"))
    assertEquals(-3, augmented.valenceOf("bad"))
  }

  @Test
  def should_add_word_map_to_list(): Unit = {
    val augmented = wl ++ Map("bad" -> -3)
    assertEquals(3, augmented.valenceOf("good"))
    assertEquals(-3, augmented.valenceOf("bad"))
  }

  @Test
  def should_add_word_lists(): Unit = {
    val augmented = wl ++ new WordList(Map("bad" -> -3))
    assertEquals(3, augmented.valenceOf("good"))
    assertEquals(-3, augmented.valenceOf("bad"))
  }
}