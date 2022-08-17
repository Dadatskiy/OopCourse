package dada.oop.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;

        if (this.from >= this.to) {
            throw new RuntimeException("Начало диапазона должно быть меньше, чем его конец!");
        }
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
        return number > from && number < to;
    }

    @Override
    public String toString () {
        return "(" + from + "; " + to + ")";
    }

    public Range getIntersection(Range range) {
        if (to > range.from && range.to > from) {
        return new Range (Math.max(from, range.from), Math.min(to, range.to));
        }

        if (from == range.from && to == range.to) {
            return new Range(from, to);
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (from == range.from && to == range.to) {
            return new Range[]{new Range(from, to)};
        }

        if (to >= range.from && range.to >= from) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }

        return from < range.from
                ? new Range[]{new Range(from, to), new Range(range.from, range.to)}
                : new Range[]{new Range(range.from, range.to), new Range(from, to)};
    }

    public Range[] getDifference(Range range) {
        if ((from > range.from && to <= range.to) || (from == range.from && to == range.to)) {
            return new Range[0];
        }

        if (to > range.from && range.to > from) {
            if (from > range.from && to > range.to) {
                return new Range[]{new Range(range.to, to)};
            }

            if (from < range.from) {
                if (to <= range.to) {
                    return new Range[]{new Range(from, range.from)};
                }

                return new Range[]{new Range(from, range.from), new Range(range.to, to)};
            }
        }

            return new Range[]{new Range(from, to)};
    }
}