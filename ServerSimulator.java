import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSimulator {

    private final ExecutorService threadPool;
    private final KVStore kvStore;

    public ServerSimulator(int threads, int cacheCapacity) {
        this.threadPool = Executors.newFixedThreadPool(threads);
        this.kvStore = new KVStore(cacheCapacity);
    }

    public void submitRequest(String op, String key, String value) {
        threadPool.submit(() -> {
            switch (op) {
                case "SET" -> kvStore.set(key, value);
                case "GET" -> System.out.println("GET " + key + " -> " + kvStore.get(key));
                case "DELETE" -> kvStore.delete(key);
            }
        });
    }

    public void shutdown() {
        threadPool.shutdown();
    }
}
