package _2_Design_Patterms;

import java.util.List;

public final class ImmutableObjectPattern {

    private final List<String> immutable;

    public ImmutableObjectPattern(final List<String> immutable) {
        if (immutable == null) {
            throw new RuntimeException("Immutable is empty");
        }
        this.immutable = immutable;
    }

    public List<String> getImmutable() { // not good for immutability
        return immutable;
    }

    public int getSizeOfImmutable() {
        return immutable.size();
    }

    public String getElementFromImmutablr(final int position) {
        return immutable.get(position);
    }
}
