import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class AirplaneAccessories {

    public static JavaCSG csg = JavaCSGFactory.createDefault();

    public static Geometry3D guns(){

        /*     main gun body     */
        var rightGun = csg.cylinder3D(5,10,100,true);
        rightGun = csg.rotate3DX(csg.degrees(90)).transform(rightGun);
        rightGun = csg.translate3D(20,10,-12).transform(rightGun);
        var leftGun = csg.cylinder3D(5,10,100,true);
        leftGun = csg.rotate3DX(csg.degrees(90)).transform(leftGun);
        leftGun = csg.translate3D(-20,10,-12).transform(leftGun);

        /*     gun tips     */
        var rightGunTip = csg.cylinder3D(2,5,100,true);
        rightGunTip = csg.rotate3DX(csg.degrees(90)).transform(rightGunTip);
        rightGunTip = csg.translate3D(20,17,-12).transform(rightGunTip);
        var leftGunTip = csg.cylinder3D(2,5,100,true);
        leftGunTip = csg.rotate3DX(csg.degrees(90)).transform(leftGunTip);
        leftGunTip = csg.translate3D(-20,17,-12).transform(leftGunTip);

        var collectedGun = csg.union3D(rightGun,rightGunTip,leftGun,leftGunTip);

        return collectedGun;

    }
}
