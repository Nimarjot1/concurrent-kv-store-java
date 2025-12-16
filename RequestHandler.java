public class RequestHandler implements Runnable {

    private final KVStore kvStore;
    private final String operation;
    private final String key;
    private final String value;

    public RequestHandler(KVStore kvStore, String operation, String key, String value) {
        this.kvStore = kvStore;
        this.operation = operation;
        this.key = key;
        this.value = value;
    }

    @Override
    public void run() {
        switch (operation) {
            case "SET" -> kvStore.set(key, value);
            case "GET" -> {
                String result = kvStore.get(key);
                System.out.println("GET " + key + " -> " + result);
            }
            case "DELETE" -> kvStore.delete(key);
            default -> System.out.println("Invalid operation");
        }
    }
}
