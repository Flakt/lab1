/**
 * The interface Movable.
 */
public interface Movable {

    /**
     * Move.
     */
    void move();

    /**
     * Turn left.
     *
     * @param angle the angle
     */
    void turnLeft(Double angle);

    /**
     * Turn right.
     *
     * @param angle the angle
     */
    void turnRight(Double angle);
}
