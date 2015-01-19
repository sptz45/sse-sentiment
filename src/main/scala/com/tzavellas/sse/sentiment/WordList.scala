package com.tzavellas.sse.sentiment

class WordList(words: Map[String, Int]) {

  private val wordsMap = words.withDefaultValue(0)

  def valenceOf(word: String): Int = wordsMap(word)

  def + (word: Tuple2[String, Int]) = {
    new WordList(words + word)
  }

  def ++ (words: Map[String, Int]) = {
    new WordList(this.wordsMap ++ words)
  }

  def ++ (wordList: WordList) = {
    new WordList(this.wordsMap ++ wordList.wordsMap)
  }
}