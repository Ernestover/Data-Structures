public class Dictionary<K,V> {
    // private K key;
    //private V value;
    private KeyValuePair<K,V>[] hashtable;
    private final KeyValuePair<K,V> DELETED = new KeyValuePair<K,V>(null,null);
    private int m;

    public Dictionary(KeyValuePair<K,V>[] hashtable, int size) {
        this.hashtable = hashtable;
        this.m = size;
    }

    private int prehash(K key){
        return key.hashCode();
    }

    private int hash(int p){ 
        if (attempt == 1){
         return p % m;
        }

        int hlinear = (hash(p) + (attempt - 1)) % m;
    }

    public void insert(K key, V value){ //not finished
        int p = prehash(key);

        int attempt = 1;
        while (attempt < m){
            int index = hash(p, attempt);
            if (hashtable[index] == null || hashtable[index] == DELETED) {
                hashtable[index] = new KeyValuePair<K,V>(key, value);
            }

            else if(hashtable[index].getKey() == key) {
                hashtable[index].setValue(value);
            }
            attempt++;
        }

        if (attempt >= m) {
            System.out.println("Dictionary is full");
        }
    }

    public V search(K key){ //not finished

        return value; 
    }

    public void delete(K key){ //not finished

    }

}