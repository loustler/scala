package scala.in.programming.abstract_internal_control

import java.io.File

/**
  * @author loustler
  * @since 02/15/2017 00:46
  */
object FileMacher {
  private def filesHere = (new File(".")).listFiles

  def filesEnding(query: String) =
    for ( file <- filesHere; if file.getName.endsWith(query) )
      yield file


  def fileContaining(query: String) =
    for ( file <- filesHere; if file.getName.contains(query) )
      yield file

  def fileRegex(query: String) =
    for ( file <- filesHere; if file.getName.matches(query) )
      yield file


  // Upper functions has duplicate source. It was not good.
  def fileMatching(query: String, matcher: (String, String) => Boolean) =
    for ( file <- filesHere; if matcher(file.getName, query) )
      yield file


  // It is like fileEncoding function.
  def filesEncoding2(query: String) =
//    fileMatching(query, (fileName, query) => fileName.endsWith(query))
    fileMatching(query, _.endsWith(_))

  // It is like fileContaining function.
  def fileContaining2(query: String) =
//    fileMatching(query, (fileName, query) => fileName.contains(query))
    fileMatching(query, _.contains(_))

  // It is like fileRegex function.
  def fileRegex2(query: String) =
//    fileMatching(query, (fileName, query) => fileName.matches(query))
    fileMatching(query, _.matches(_))

}
