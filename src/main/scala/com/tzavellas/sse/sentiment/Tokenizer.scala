package com.tzavellas.sse.sentiment

private object Tokenizer {
  
  private val alphaRegex = "[^a-zA-Z\\s]".r
  private val redundantWhitespaceRegex = "[\\s]{2,}".r
  private val whitespaceRegex = "\\s".r  

  def tokenize(phrase: String): Array[String] = {
    var normalized = alphaRegex.replaceAllIn(phrase, "")
    normalized = redundantWhitespaceRegex.replaceAllIn(normalized, " ")
    normalized = normalized.toLowerCase
    whitespaceRegex.split(normalized)
  }
}