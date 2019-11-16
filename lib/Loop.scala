object Loop {
  @inline def rep(n: Int, f: => Unit): Unit = { var c = 0; while (c < n) { f; c += 1 } }
  @inline def rep(n: Int, f: Int => Unit): Unit = { var c = 0; while (c < n) { f(c); c += 1 } }

  @inline def breakAble(n: Int, m: Int, f: Int => Boolean): Unit = if (f(n) && n < m) breakAble(n + 1, m, f)
  @inline def !(n: Int): Int = (1 + n) * n / 2
}
