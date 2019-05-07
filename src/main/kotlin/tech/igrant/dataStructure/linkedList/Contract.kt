package tech.igrant.dataStructure.linkedList

interface Contract<T> {

    /**
     * return the node has value equals input, otherwise return null
     */
    fun search(value: T): Node<T>?

    /**
     * return true if insert success, otherwise return false
     */
    fun insert(value: T, toInsert: Node<T>): Boolean

    /**
     * return the node removed if remove success, otherwise return null
     */
    fun remove(value: T): Node<T>?

    /**
     * return true if list is empty, false otherwise
     */
    fun empty(): Boolean

    /**
     * return true if linkedList has a cycle in it
     */
    fun cycle(): Boolean

    /**
     * reverse a linkedList
     */
    fun reverse()

}