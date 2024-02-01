import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Interface for Priority
interface Priority {
    void setPriority(int priority);
    int getPriority();
}

// Interface for Complexity
interface Complexity {
    void setComplexity(int complexity);
    int getComplexity();
}

// Task class implementing Priority, Complexity, and Comparable interfaces
class Task implements Priority, Complexity, Comparable<Task> {
    private int priority;
    private int complexity;
    private String name;

    // Constructor to initialize task with name, priority, and complexity
    public Task(String name, int priority, int complexity) {
        this.name = name;
        this.priority = priority;
        this.complexity = complexity;
    }

    // Getter method for task name
    public String getName() {
        return name;
    }

    // Priority interface methods
    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    // Complexity interface methods
    @Override
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    @Override
    public int getComplexity() {
        return complexity;
    }

    // Comparable interface method for natural ordering
    @Override
    public int compareTo(Task otherTask) {
        int priorityComparison = Integer.compare(this.priority, otherTask.priority);
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        return Integer.compare(this.complexity, otherTask.complexity);
    }

    // String representation of the Task
    @Override
    public String toString() {
        return "Task [Name=" + name + ", Priority=" + priority + ", Complexity=" + complexity + "]";
    }
}

// Main class for managing and sorting tasks
public class TaskManager {
    public static void main(String[] args) {
        // Create a list of tasks
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Watch Survivor", 3, 1));
        tasks.add(new Task("Eat Dinner", 2, 1));
        tasks.add(new Task("Go to Crew Practice", 3, 3));
        tasks.add(new Task("Do Homework", 1, 5));
        tasks.add(new Task("Feed the Dog", 2, 2));

        // Sort the tasks based on priority and complexity
        Collections.sort(tasks);

        // Print the sorted tasks
        System.out.println("Sorted Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
