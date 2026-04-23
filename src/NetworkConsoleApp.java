import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

/**
 *
 * @author Phong
 */
public class NetworkConsoleApp {
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== NETWORK CONSOLE APP ===");
            System.out.println("1. Show my local IP");
            System.out.println("2. List IPs in the network");
            System.out.println("3. Find an IP in the network");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showLocalIP();
                case "2" -> scanNetwork();
                case "3" -> {
                    System.out.print("Enter IP to search: ");
                    String targetIP = scanner.nextLine();
                    searchIP(targetIP);
                }
                case "4" -> {
                    System.out.println("Exiting program.");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void showLocalIP() throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("Local IP: " + localHost.getHostAddress());
    }

    private static void scanNetwork() throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        String localIP = localHost.getHostAddress();
        String subnet = getSubnet(localIP);

        System.out.println("Scanning network: " + subnet + ".1-254 ...");

        ExecutorService executor = Executors.newFixedThreadPool(50);
        List<Future<String>> results = new ArrayList<>();

        for (int i = 1; i <= 254; i++) {
            final String host = subnet + "." + i;
            results.add(executor.submit(() -> scanHost(host)));
        }

        for (Future<String> f : results) {
            String res = f.get();
            if (res != null) System.out.println(res);
        }

        executor.shutdown();
        System.out.println("Scan completed.");
    }

    private static void searchIP(String targetIP) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Future<String> result = executor.submit(() -> scanHost(targetIP));

        String res = result.get();
        if (res != null) {
            System.out.println("Found: " + res);
        } else {
            System.out.println("IP " + targetIP + " was not found in the network.");
        }

        executor.shutdown();
    }

    private static String getSubnet(String ip) {
        String[] parts = ip.split("\\.");
        return parts[0] + "." + parts[1] + "." + parts[2];
    }

    private static String scanHost(String host) {
        try {
            InetAddress inet = InetAddress.getByName(host);
            if (inet.isReachable(100)) {
                return "ACTIVE: " + host + " (" + inet.getHostName() + ")";
            }
        } catch (IOException e) {
            // ignore
        }
        return null;
    }
}
