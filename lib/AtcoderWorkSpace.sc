import java.io.PrintWriter

object Loop {
  @inline def rep(n: Int, f: => Unit): Unit = { var c = 0; while (c < n) { f; c += 1 } }
  @inline def rep(n: Int, f: Int => Unit): Unit = { var c = 0; while (c < n) { f(c); c += 1 } }

  @inline def breakAble(n: Int, m: Int, f: Int => Boolean): Unit = if (f(n) && n < m) breakAble(n + 1, m, f)
  @inline def !(n: Int): Int = (1 + n) * n / 2
}
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
object Scanner {
  private val buf = new Array[Byte](1024); private var ptr = 0; private var len = 0
  @inline private def isPrintableChar(c: Int): Boolean = 33 <= c && c <= 126
  @inline private def hasNextByte(): Boolean =
    if (ptr >= len) { ptr = 0; len = System.in.read(buf); len > 0 } else { true }
  @inline private def hasNext(): Boolean = {
    while (hasNextByte() && !isPrintableChar(buf(ptr))) ptr += 1
    hasNextByte()
  }
  @inline private def readByte(): Byte =
    if (hasNextByte()) { val res = buf(ptr); ptr += 1; res } else { -1 }
  def next(): String = {
    if(!hasNext()) ???
    val sb = new StringBuilder; var b = readByte()
    while (isPrintableChar(b)) { sb.append(b.toChar); b = readByte() }
    sb.toString
  }
  def nextInt(): Int = {
    val n = nextLong()
    if (n < Int.MinValue || Int.MaxValue < n) ???
    n.toInt
  }
  def nextLong(): Long = {
    if(!hasNext()) ???
    var minus = false; var b = readByte()
    if (b == '-') { minus = true; b = readByte() }
    def go (b: Byte, n: Long = 0): Long =
      if ('0' <= b && b <= '9') { go(readByte(), n * 10 + b - '0') }
      else if (minus) { -n } else { n }
    go(b)
  }
  def nextDouble(): Double = next.toDouble

  def print(f:PrintWriter => Unit): Unit = {
    val pw: PrintWriter = new java.io.PrintWriter(System.out)
    //pw.println("")
    f(pw)
    pw.flush()
  }
}
////////////////////////////////////////
//
////////////////////////////////////////
object Main extends App {
  val n = Scanner.nextInt()

}
////////////////////////////////////////
//
////////////////////////////////////////
val start = java.time.Instant.now().toEpochMilli

println(java.time.Instant.now().toEpochMilli - start)
