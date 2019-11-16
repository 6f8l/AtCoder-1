object Mod {
  def create(n: Int, mod: Int) = Mod(n, mod)
}
case class Mod(n: Int, mod: Int) {
  val factorial: Array[Int] = Array.fill[Int](n + 1)(1)
  val inverse: Array[Int] = Array.fill[Int](n + 1)(1)
  val inverseFactorial: Array[Int] = Array.fill[Int](n + 1)(1)
  Loop.rep(n - 1, i => {
    val k = i + 2
    factorial(k) = modMultiplyExact(factorial(k - 1), k, mod)
    inverse(k) = modMultiplyExact(inverse(mod % k), mod - (mod / k): Int, mod)
    inverseFactorial(k) = modMultiplyExact(inverseFactorial(k - 1), inverse(k), mod)
  })
  def getFactorial(n: Int): Int = factorial(n)
  def getInverse(n: Int): Int = inverse(n)
  def getInverseFactorial(n: Int): Int = inverseFactorial(n)
  def C(n: Int, k: Int): Int = {
    //TODO あってるけど境界条件綺麗に
    if (n <= 0 || k < 0 || k > n) 0 else if (k == 0 || k == n) 1 else {
      modMultiplyExact(
        getFactorial(n),
        getInverseFactorial(n - k),
        getInverseFactorial(k),
        mod
      )
    }
  }
  def modMultiplyExact(a: Int, b: Int, m: Int): Int =
    ((a.toLong * b.toLong) % m).toInt
  def modMultiplyExact(a: Int, b: Int, c: Int, m: Int): Int =
    modMultiplyExact(a, modMultiplyExact(b, c, m), m)
}
