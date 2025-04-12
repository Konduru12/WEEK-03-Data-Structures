class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTourProblem {

    static int findStartPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;
        int currPetrol = 0;
        int totalDeficit = 0;
        for (int i = 0; i < n; i++) {
            currPetrol += pumps[i].petrol - pumps[i].distance;
            if (currPetrol < 0) {
                totalDeficit += currPetrol;
                start = i + 1;
                currPetrol = 0;
            }
        }
        return (currPetrol + totalDeficit >= 0) ? start : -1;
    }
    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };
        int start = findStartPoint(pumps);
        if (start != -1)
            System.out.println("Start at petrol pump index: " + start);
        else
            System.out.println("No feasible starting point exists.");
    }
}
