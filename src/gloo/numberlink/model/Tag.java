package gloo.numberlink.model;

import java.util.Objects;

public class Tag {

    /**
     * A label is uniquely identified by its label, ranging from 1 to the number of tags in the puzzle.
     */
    private final int label;

    public Tag(int label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;
        Tag other = (Tag) obj;
        return getLabel().equals(other.getLabel());
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
