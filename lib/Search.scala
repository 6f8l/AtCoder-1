object Search {
  def find(data: Array[Int], key: Int): Option[Int] = {
    val res = java.util.Arrays.binarySearch(data, key)
    if (res >= 0) Some(res) else None
  }
}
