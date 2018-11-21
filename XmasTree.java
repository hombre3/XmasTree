import java.util.Objects;

public class XmasTree {

    private final int width;

    //Constructor
    public XmasTree(final int width) {
        final boolean positivEven = width > 0 && width % 2 == 1;
        if (positivEven) {
            this.width = width;
        } else {
            throw new IllegalArgumentException();
        }
    }

   // private String printXmasTree(){


   // }

    public String text() {
        String tree = "";


        final int halfTreeWidth = width / 2;
        final int hight = halfTreeWidth + 3;

        int numberOfDota = halfTreeWidth;


        for (int row = 0; row < hight; row++) {
            for (int column = 0; column < getWidth(); column++) {
                final boolean isNumberOfDota = column < numberOfDota || column >= getWidth() - numberOfDota;
                if (row == 0) {
                    if (isNumberOfDota) {
                        tree += '.';
                    } else {
                        tree += '*';
                    }
                } else if (row == hight - 1) {
                    numberOfDota = halfTreeWidth;
                    if (isNumberOfDota) {
                        tree += '.';
                    } else {
                        tree += '|';
                    }
                } else {
                    if (isNumberOfDota) {
                        tree += '.';
                    } else {
                        tree += '#';
                    }
                    if (column == getWidth() - 1) {
                        numberOfDota--;
                    }
                }

            }

            tree += '\n';
        }
        return tree;
    }

    public int getWidth() {
        return width;

    }


    public XmasTree taller(XmasTree that) {
        final XmasTree outputTree;
        final XmasTree xmasTreeTaller = new XmasTree(Integer.MAX_VALUE);
        final XmasTree xmasTreeTallerWithTwo = new XmasTree(getWidth() + 2);
        if (xmasTreeTallerWithTwo.equals(xmasTreeTaller)) {
            outputTree = this;
        } else {
            outputTree = that;
        }
        return outputTree;
    }

    public XmasTree smaller(XmasTree that) {
        final XmasTree outputTree;
        final XmasTree xmasTree = new XmasTree(this.getWidth() - 2);
        if (that.equals(xmasTree)) {
            outputTree = this;
        } else {
            outputTree = that;
        }
        return outputTree;
    }

    public boolean isSmallerThan(XmasTree that) {
        final boolean output;
        if (this.getWidth() < that.getWidth()) {
            output = true;
        } else {
            output = false;
        }
        return output;

    }

    public XmasTree smallerOf(XmasTree that) {
        final XmasTree outputTree;
        if (this.isSmallerThan(that)) {
            outputTree = this;
        } else {
            outputTree = that;
        }
        return outputTree;
    }
}



