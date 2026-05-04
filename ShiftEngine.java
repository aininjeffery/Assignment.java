// Contributed by: Member 2
// Purpose: Handle hashing (groupShift) and finalShift calculation

public class ShiftEngine {

    // Hardcoded group ID (DO NOT display in UI)
    private static final String groupID = "G02/SE";

    // Method: generateShift()
    // Uses hashCode and ensures value between 1–10
    public static int generateShift() {
        int hash = groupID.hashCode();

        // Ensure positive value and limit between 1–10
        int groupShift = Math.abs(hash % 10) + 1;

        return groupShift;
    }

    // Method: calculateFinalShift()
    // Adds groupShift + character count
    public static int calculateFinalShift(int charCount) {
        int groupShift = generateShift();
        int finalShift = groupShift + charCount;
        return finalShift;
    }
}
