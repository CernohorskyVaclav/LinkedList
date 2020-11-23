fun main() {
    val a: LinkedList<Int> = LinkedList(
        1,LinkedList(
            2,LinkedList(
                3,LinkedList(
                    4,LinkedList(
                        5,null)
                )
            )
        )
    )
}
class LinkedList<E>(
    private val value: E,
    private val next: LinkedList<E>?
): List<E> {
    override val size: Int
    get() {
        if (next== null) return 1
        return 1 + next.size
    }
    override fun contains(element: E): Boolean {
        return indexOf(element) >=0
    }
    override fun containsAll(elements: Collection<E>): Boolean {
        for (element in elements) {
            if(!contains(element)) return false
        }
        return true
    }
    override fun get(index: Int): E {
        return when (index) {
            0 -> value
            else -> {
                if (next == null) throw ArrayIndexOutOfBoundsException()
                else next[index-1]
            }
        }
    }
    override fun indexOf(element: E): Int {
        return if (value == element) 0
        else if (next == null) -1
        else {
            val index: Int = next.indexOf(element)
            if (index == -1) {
                -1
            } else{
                index+1
            }
        }
    }
    override fun lastIndexOf(element: E): Int {
        val index: Int? = when {
            next!= null -> next.lastIndexOf(element)
            else -> null
        }
        when (index) {
            null -> {
                return when (value){
                    element -> 0
                    else -> -1
                }
            }
            -1 -> {
                if(element ==value) return 0
                return -1
            }
            else -> {
                return index + 1
            }
        }
        return -1
    }
    override fun isEmpty(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun iterator(): Iterator<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun listIterator(): ListIterator<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun listIterator(index: Int): ListIterator<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun subList(fromIndex: Int, toIndex: Int): List<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}