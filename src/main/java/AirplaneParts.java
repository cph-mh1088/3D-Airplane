import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class AirplaneParts {

    public static JavaCSG csg = JavaCSGFactory.createDefault();

    public static Geometry3D body() {

        /*     AirplaneFrame     */
        var frame = csg.cylinder3D(10,50,100,true);
        frame = csg.rotate3DX(csg.degrees(90)).transform(frame);

        /*     AirplaneWings     */
        var upperWings = csg.box3D(50,10,5,true);
        upperWings = csg.translate3D(0,10,7.5).transform(upperWings);
        var lowerWings = csg.box3D(50,10,5,true);
        lowerWings = csg.translate3D(0,10,-7.5).transform(lowerWings);

        /*     AirplanePropeller     */
        var propeller = csg.box3D(20,2,2,true);
        propeller = csg.translate3D(0,26,0).transform(propeller);
        propeller = csg.rotate3D(csg.degrees(0),csg.degrees(50),csg.degrees(0)).transform(propeller);

        /*     AirplaneWheels     */
        var rightWheel = csg.flatRing3D(0,5,2,100,false);
        rightWheel = csg.translate3D(12.5,10,-10).transform(rightWheel);
        rightWheel = csg.rotate3D(csg.degrees(0),csg.degrees(90), csg.degrees(0)).transform(rightWheel);
        var leftWheel = csg.flatRing3D(0,5,2,100,false);
        leftWheel = csg.translate3D(12.5,10,10).transform(leftWheel);
        leftWheel = csg.rotate3D(csg.degrees(0),csg.degrees(90), csg.degrees(0)).transform(leftWheel);

        /*     Tail pieces     */
        var rightTail = csg.box3D(2,10,5,false);
        rightTail = csg.translate3D(0,-20,5).transform(rightTail);
        rightTail = csg.rotate3D(csg.degrees(0), csg.degrees(90), csg.degrees(0)).transform(rightTail);
        var leftTail = csg.box3D(2,10,5,false);
        leftTail = csg.translate3D(0,-20,-10).transform(leftTail);
        leftTail = csg.rotate3D(csg.degrees(0), csg.degrees(90), csg.degrees(0)).transform(leftTail);
        var uprightTail = csg.box3D(2,10,5,true);
        uprightTail = csg.translate3D(0,-20,7).transform(uprightTail);

        var assembledAirplane = csg.union3D(frame,upperWings,lowerWings,propeller,rightWheel,leftWheel,rightTail,leftTail,uprightTail);

        return assembledAirplane;
    }
}
