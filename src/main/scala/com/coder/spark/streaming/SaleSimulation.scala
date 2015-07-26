package com.coder.spark.streaming

import scala.util.Random
import scala.io.Source
import scala.Array
import java.net.ServerSocket
import java.io.PrintWriter

/**
 * Created by Administrator on 2015/7/26.
 * java -cp .;D:\install\scala-2.10.4\lib\scala-library.jar;D:\install\scala-2.10.4\lib\scala-swing.jar;D:\install\scala-2.10.4\lib\scala-actors.jar;streaming.jar com.coder.spark.streaming.SaleSimulation D:\data\data.txt 9999 1000
 */
object SaleSimulation {
  def index(length: Int) = {
    val ram = new Random()
    ram.nextInt(length)
  }

  def getLines(file: String) = {
    val lines = Source.fromFile(file).getLines() //iterator 是指每一行
/*    while (lines.hasNext) {
      val str = lines.next()
      println(str)
    }*/
    lines.toList //如果一直迭代，则到最后，lines,toList为空，因为跌代到最后
  }

  def main(args: Array[String]) {
    if(args.length < 3){
       System.err.println("Usage: <filename> <port> <millisecond>")
       System.exit(1)
     }
    //Array(file,port,ms) = args
    println(getLines("D:\\data\\data.txt"))
    SendMessage(args(0),args(1).toInt,args(2).toLong)

  }


  def SendMessage(file: String, port:Int ,sleepTime:Long){
    val server = new ServerSocket(port)
    val lines = getLines(file)
    val length = lines.length
    while(true){
      val socket =server.accept()
      println("Got client connected from: " + socket.getInetAddress)
      val out = new PrintWriter(socket.getOutputStream,true)
      new Thread() {
        override def run(): Unit = {
          while(true){
            Thread.sleep(sleepTime)
            val text = lines(index(length))
            println("Send Message from Server : " + text)
            val content =text +"\n"
            out.write(content)
            out.flush()
          }
          socket.close()
        }
      }.start
    }
  }
}
