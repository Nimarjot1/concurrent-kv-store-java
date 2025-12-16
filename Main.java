public class Main {
    public static void main(String[] args) {

        ServerSimulator server = new ServerSimulator(4, 2);

        server.submitRequest("SET", "A", "1");
        server.submitRequest("SET", "B", "2");
        server.submitRequest("GET", "A", null);
        server.submitRequest("SET", "C", "3"); // Evicts B
        server.submitRequest("GET", "B", null); // null
        server.submitRequest("GET", "A", null); // 1

        server.shutdown();
    }
}
