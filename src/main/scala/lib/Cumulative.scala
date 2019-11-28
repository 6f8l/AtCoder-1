package lib

object Cumulative {

  case class CumulativeProduct(arr: Array[Int]) {
    val n = arr.length
    val sumArray: Array[Int] = Array.fill[Int](n + 1)(1)
    Loop.rep(n, i => sumArray(i + 1) = sumArray(i) * arr(i))

    //TODO 半開区間に変更
    //座標指定 上限下限共に含む
    def countByCoordinate(start: Int, end: Int): Int =
      countBySubscript(start - 1, end - 1)

    //添字指定 上限下限共に含む
    def countBySubscript(start: Int, end: Int): Int = {
      if (start <= end) sumArray(end + 1) / sumArray(start)
      else sumArray(start + 1) / sumArray(end)
    }
  }
  case class CumulativeSum(arr: Array[Int]) {
    val n = arr.length
    val sumArray: Array[Int] = Array.fill[Int](n + 1)(0)
    Loop.rep(n, i => sumArray(i + 1) = sumArray(i) + arr(i))

    //TODO 半開区間に変更
    //座標指定 上限下限共に含む
    def countByCoordinate(start: Int, end: Int): Int =
      countBySubscript(start - 1, end - 1)

    //添字指定 上限下限共に含む
    def countBySubscript(start: Int, end: Int): Int = {
      if (start <= end) sumArray(end + 1) - sumArray(start)
      else sumArray(start + 1) - sumArray(end)
    }
  }

}
