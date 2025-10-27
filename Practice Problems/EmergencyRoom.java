import java.util.*;

class Patient {
    String name;
    int priority;
    Patient(String n, int p) { name = n; priority = p; }
    public String toString() { return name; }
}

public class EmergencyRoom {
    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>(Comparator.comparingInt(p -> -p.priority));
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Command (ARRIVE <name> <priority>/TREAT/STATUS/EXIT): ");
            String cmd = sc.next();
            if (cmd.equalsIgnoreCase("ARRIVE")) {
                String name = sc.next();
                int prio = sc.nextInt();
                pq.add(new Patient(name, prio));
            } else if (cmd.equalsIgnoreCase("TREAT")) {
                if (!pq.isEmpty()) {
                    Patient p = pq.poll();
                    System.out.println("Treating " + p.name + " (Priority " + p.priority + ")");
                }
            } else if (cmd.equalsIgnoreCase("STATUS")) {
                List<String> names = new ArrayList<>();
                for (Patient pat : pq) names.add(pat.name);
                System.out.println("Waiting: " + names);
            } else if (cmd.equalsIgnoreCase("EXIT")) {
                break;
            }
        }
    }
}
