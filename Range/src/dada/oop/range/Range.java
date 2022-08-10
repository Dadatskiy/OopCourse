package dada.oop.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(double newFrom, double newTo) {
        if (to > newFrom && newTo > from) {
            if (from > newFrom && to > newTo) {
                return new Range(from, newTo);
            } else if (from < newFrom && to < newTo) {
                return new Range(newFrom, to);
            } else if (from > newFrom && to < newTo) {
                return new Range(from, to);
            } else if (from < newFrom && to > newTo) {
                return new Range(newFrom, newTo);
            }
        }

        return null;
    }

    public Range[] getUnion(double newFrom, double newTo) {
        if (from == newFrom && to == newTo) {
            return null;
        }

        if (to > newFrom && newTo > from) {
            if (from > newFrom && to > newTo) {
                return new Range[]{new Range(newFrom, to)};
            } else if (from < newFrom && to < newTo) {
                return new Range[]{new Range(from, newTo)};
            } else if (from > newFrom && to < newTo) {
                return new Range[]{new Range(newFrom, newTo)};
            } else if (from < newFrom && to > newTo) {
                return new Range[]{new Range(from, to)};
            }
        }

        return from < newFrom ? new Range[]{new Range(from, to), new Range(newFrom, newTo)} :
                new Range[]{new Range(newFrom, newTo), new Range(from, to)};
    }

    public Range[] getDifference(double newFrom, double newTo) {
        if (to > newFrom && newTo > from) {
            if (from > newFrom && to > newTo) {
                return new Range[]{new Range(newTo, to)};
            } else if (from < newFrom && to < newTo) {
                return new Range[]{new Range(from, newFrom)};
            } else if (from < newFrom && to > newTo) {
                return new Range[]{new Range(from, newFrom), new Range(newTo, to)};
            }
        }

        if ((from > newFrom && to < newTo) || (from < newFrom && to < newTo) || (from == newFrom && to == newTo)) {
            return null;
        }

        return new Range[]{new Range(from, newFrom), new Range(newTo, to)};
    }
}