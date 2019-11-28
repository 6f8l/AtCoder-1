package lib

object WarshallFloyd {
  def create(arr: Array[Array[Int]]): WarshallFloyd = {
    val i = WarshallFloyd(arr)
    i.run
    i
  }
}

case class WarshallFloyd(arr: Array[Array[Int]]) {
  lazy val n: Int = arr.length
  private def run: Unit = {
    Loop.rep(n, k => {
      Loop.rep(n, i => {
        Loop.rep(n, j => {
          val distance = Math.min(arr(i)(j), arr(i)(k) + arr(k)(j))
          arr(i)(j) = distance
        })
      })
    })
  }
  def get(x: Int, y: Int): Int = arr(x)(y)
}
