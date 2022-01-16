package gloo.numberlink.model;

public class Tag {

    /**
     * A label is uniquely identified by its label, ranging from 1 to the number of tags in the puzzle.
     */
    private final int label;

    public Tag(int label) {
        this.label = label;
    }

    public String getLabel() {
        return Integer.toString(this.label);
    }

    public String toString() {
        return getLabel();
    }

    public Path createNewPath(){
        return new Path(this);
    }
}
