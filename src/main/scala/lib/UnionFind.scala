package lib

case class UnionFind(n: Int) {
  //添字が固有ID、値が親IDを表す
  val arr: Array[Int] = Array.tabulate[Int](n)(identity)
  def findParent(v: Int): Int = {
    val parent = arr(v)
    if (v == parent) parent else findParent(parent)
  }
  def registerParent(child: Int, parent: Int): Unit = {
    val oldParent = arr(child)
    arr(oldParent) = parent
  }
}
