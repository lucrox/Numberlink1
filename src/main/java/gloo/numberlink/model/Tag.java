package gloo.numberlink.model;

/**
 * Record for saving, comparing and providing information about the label of a cell.
 */
public record Tag(int label) {

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

    public Path createNewPath() {
        return new Path(this);
    }
}
