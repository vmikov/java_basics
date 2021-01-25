package hw_21;

public class ThreadInherited extends Thread implements CounterCollaborator{
    public static final String NAME = "ThreadInherited";
    private int iteration;

    @Override
    public void run() {
        setName(NAME);

        int value = 0;

        for (iteration = 1; iteration <= 1000; ++iteration) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = Counter.increment();

            //to get into deadlock uncomment the next line in at least two instances of CounterCollaborator
            //displayCollaboration();
        }

        System.out.printf("%s is done with Counter's value %d%n", NAME, value);
    }

    private synchronized void displayCollaboration() {
        CollaborationManager.displayCollaboration();
    }

    @Override
    public synchronized String getCollaboratorState() {
        return String.format("Collaborator %s is on %d iteration", NAME, iteration);
    }
}
