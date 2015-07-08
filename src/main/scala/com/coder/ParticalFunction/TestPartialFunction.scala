package com.coder.ParticalFunction

/**
 * 被包在花括号的一组case语句是一个偏函数，他是ParticalFunction的一个实例
 */
object TestPartialFunction {
  def main(args: Array[String]) {
    val f:PartialFunction[Char,Int]={
      case '+'=>1
      case '-'=>0
    }
    f('+')//f.apply('+')返回1
    f.isDefinedAt('0')
   // f('0')
    val p="-3+4" collect {case '-'=>1;case '+'=> 0}
    println(p)
  }

}
