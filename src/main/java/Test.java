import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Test
{
	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();

		Geometry3D airplane = AirplaneParts.body();
		Geometry3D gun = AirplaneAccessories.guns();

		var completeAirplane = csg.union3D(airplane,gun);

		csg.view(completeAirplane);

	}
}
