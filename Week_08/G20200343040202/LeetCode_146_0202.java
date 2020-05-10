class LRUCache {

    /**
     * 链表节点
     */
    class CacheNode {
        CacheNode prev;//前一节点
        CacheNode next;//后一节点
        int value;//值
        int key;//键
        CacheNode() {
        }
    }
    public LRUCache(int capacity) {
        currentSize = 0;
        cacheSize = capacity;
        nodes = new LinkedHashMap();//缓存容器
    }

    /**
     * 获取缓存中对象
     * @param key
     * @return
     */
    public int get(int key) {
        CacheNode node = (CacheNode) nodes.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    /**
     * 添加缓存
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        CacheNode node = (CacheNode) nodes.get(key);

        if (node == null) {
            //缓存容器是否已经超过大小.
            if (currentSize >= cacheSize) {
                if (last != null)//将最少使用的删除
                    nodes.remove(last.key);
                removeLast();
            } else {
                currentSize++;
            }

            node = new CacheNode();
        }
        node.value = value;
        node.key = key;
        //将最新使用的节点放到链表头，表示最新使用的.
        moveToHead(node);
        nodes.put(key, node);
    }

    /**
     * 删除链表尾部节点
     *  表示 删除最少使用的缓存对象
     */
    private void removeLast() {
        //链表尾不为空,则将链表尾指向null. 删除连表尾（删除最少使用的缓存对象）
        if (last != null) {
            if (last.prev != null)
                last.prev.next = null;
            else
                first = null;
            last = last.prev;
        }
    }

    /**
     * 移动到链表头，表示这个节点是最新使用过的
     * @param node
     */
    private void moveToHead(CacheNode node) {
        if (node == first)
            return;
        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        if (last == node)
            last = node.prev;
        if (first != null) {
            node.next = first;
            first.prev = node;
        }
        first = node;
        node.prev = null;
        if (last == null)
            last = first;
    }
    private int cacheSize;
    private LinkedHashMap nodes;//缓存容器
    private int currentSize;
    private CacheNode first;//链表头
    private CacheNode last;//链表尾
}