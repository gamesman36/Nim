public class Heap {
    private int numOfObjects;

    public Heap(int numOfObjects){
        this.numOfObjects = numOfObjects;
    }

    public int GetNumOfObjects(){
        return this.numOfObjects;
    }

    public boolean RemoveObjects(int howMany){
        if(howMany > 0 && howMany <= this.numOfObjects) {
            this.numOfObjects -= howMany;
            System.out.println("Removed " + howMany + " objects.");
            return true;
        }
        else {
            System.out.println("Invalid input: try again.");
            return false;
        }
    }
}
