object PrimeNumbers {
  def isPrimeNumber(n: Int): Boolean = ???
  def createUntil(n: Int): Array[Int] = {
    val arr: Array[Int] = Array.empty
    //i = 2からスタートしたいので全体をずらす
    Loop.rep(n - 2, i => {
      //自身より小さい全ての素数で割り切れなければ、素数
      if (!arr.exists(v => i % v == 0)) {
        //append
      }
    })
    arr
  }
}
