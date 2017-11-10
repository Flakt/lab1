import com.sun.javafx.geom.Vec2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Cars is an abstract base class for all cars which
 * allows the creation of cars with different attributes.
 * <br>
 * A Cars object encapsulates all state information necessary
 * for creating different types of car objects. This state information
 * includes:
 * <ul>
 * <li>The current vector</li>
 * <li>The current point</li>
 * <li>Amount of doors</li>
 * <li>Amount of engine power</li>
 * <li>The current speed</li>
 * <li>The color</li>
 * <li>The model name</li>
 * </ul>
 * <br>
 *
 * @author Stefan Chan
 * @version %I% %G%
 * @since 1.8
 */
abstract class Cars extends Vehicle {

    private int nrDoors; // Number of doors on the car

    /**
     * Class constructor.
     */
    protected Cars() {
        setNrDoors(4);
    }

    /**
     * Get nr doors int.
     *
     * @return number of doors in the car-object.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Sets nr doors.
     *
     * @param doors the amount of doors. A int.
     */
    protected void setNrDoors(int doors) {
        nrDoors = doors;
    }

    protected BufferedImage getImage() {
        try {
            return ImageIO.read(new File("src\\pics\\" + getModelName() + ".jpg"));
        }
        catch(IOException ex)
            {
                ex.printStackTrace();
            }
       return null;
    }
}
