package lecture3

data class Figure(val width: Int, val length: Int) {
    val area get() = width * length
}
