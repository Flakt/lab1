import java.awt.*;

/**
 * Created by schan on 2017-10-31.
 */
public class Volvo240 extends Cars {

        public final static double trimFactor = 1.25;

        public Volvo240(){
            setColor(Color.BLACK);
            setModelName("Volvo240");
            stopEngine();
        }

        private double speedFactor(){
            return getEnginePower() * 0.01 * trimFactor;
        }

}
