import java.util.ArrayList;
import java.util.Scanner;

public class EventManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Organizer organizer = new Organizer("Event Organizer Inc.");

        // Pre-loading data (optional)
        preLoadData(organizer);

        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createEvent(organizer, scanner);
                    break;
                case 2:
                    RSVPToEvent(organizer, scanner);
                    break;
                case 3:
                    submitFeedback(organizer, scanner);
                    break;
                case 4:
                    viewEvents(organizer);
                    break;
                case 5:
                    viewAttendeeDetails(organizer, scanner);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting Event Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Event Management System Menu ---");
        System.out.println("1. Create Event");
        System.out.println("2. RSVP to Event");
        System.out.println("3. Submit Feedback for Event");
        System.out.println("4. View Events");
        System.out.println("5. View Attendee Details");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createEvent(Organizer organizer, Scanner scanner) {
        System.out.println("Enter event name:");
        String eventName = scanner.nextLine();
        System.out.println("Enter event date:");
        String eventDate = scanner.nextLine();
        System.out.println("Enter maximum number of attendees:");
        int maxAttendees = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        ArrayList<String> speakers = new ArrayList<>();
        System.out.println("Enter number of speakers:");
        int numSpeakers = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        for (int i = 0; i < numSpeakers; i++) {
            System.out.println("Enter speaker " + (i + 1) + " name:");
            speakers.add(scanner.nextLine());
        }

        organizer.createEvent(eventName, eventDate, "Conference", maxAttendees, speakers);
        System.out.println("Event created successfully!");
    }

    private static void RSVPToEvent(Organizer organizer, Scanner scanner) {
        System.out.println("Enter your name:");
        String attendeeName = scanner.nextLine();

        System.out.println("Enter the event name you want to RSVP to:");
        String eventName = scanner.nextLine();

        organizer.RSVP(attendeeName, eventName);
        System.out.println("RSVP successful!");
    }

    private static void submitFeedback(Organizer organizer, Scanner scanner) {
        System.out.println("Enter event name for feedback submission:");
        String eventName = scanner.nextLine();

        System.out.println("Enter your name:");
        String attendeeName = scanner.nextLine();

        System.out.println("Enter your feedback:");
        String feedback = scanner.nextLine();

        organizer.submitFeedback(eventName, attendeeName, feedback);
        System.out.println("Feedback submitted successfully!");
    }

    private static void viewEvents(Organizer organizer) {
        System.out.println("--- Events ---");
        for (Event event : organizer.getEvents()) {
            System.out.println(event);
        }
    }

    private static void viewAttendeeDetails(Organizer organizer, Scanner scanner) {
        System.out.println("Enter attendee name:");
        String attendeeName = scanner.nextLine();

        System.out.println("Enter the event name (or leave blank to view all attended events):");
        String eventName = scanner.nextLine();

        // Implement logic to view attendee details based on the provided information
    }

    private static void preLoadData(Organizer organizer) {
        ArrayList<String> speakers1 = new ArrayList<>();
        speakers1.add("Speaker 1");
        speakers1.add("Speaker 2");

        ArrayList<String> speakers2 = new ArrayList<>();
        speakers2.add("Speaker A");
        speakers2.add("Speaker B");

        organizer.createEvent("Conference 1", "2024-05-01", "Conference", 100, speakers1);
        organizer.createEvent("Conference 2", "2024-05-15", "Conference", 150, speakers2);

        // Implement logic to preload additional data if necessary
    }
}
