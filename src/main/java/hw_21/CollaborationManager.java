package hw_21;

import java.util.Arrays;

public class CollaborationManager {
    private static CounterCollaborator[] collaborators;

    public static CounterCollaborator[] getCollaborators() {
        return collaborators;
    }

    public static void setCollaborators(CounterCollaborator... collaborators) {
        CollaborationManager.collaborators = collaborators;
    }

    public static synchronized void displayCollaboration() {
        System.out.println(Arrays
                .stream(collaborators)
                .map(CounterCollaborator::getCollaboratorState)
                .reduce((a,s) -> String.join(", ", a, s)));
    }
}
