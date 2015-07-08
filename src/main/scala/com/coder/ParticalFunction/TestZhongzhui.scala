package com.coder.ParticalFunction

/**
 * Created by Administrator on 15-1-18.
 */
object TestZhongzhui {
  def main(args: Array[String]) {
  val lst=1 +:7 +:2 +:9 +: Nil
    println(lst)
    lst match {
      case first +:second+:result =>{
        println(first)
        println(second)
        println(result)
      }
    }
  }
}
case object +:{

  def unapply[T](input:List[T])={
    if(input.isEmpty) None else Some(input.head,input.tail)
  }

}