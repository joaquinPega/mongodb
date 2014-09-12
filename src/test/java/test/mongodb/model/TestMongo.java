package test.mongodb.model;

import org.mongodb.model.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class TestMongo {

	public static void main(String[] args) {
		try {
			MongoClient mongoClient = new MongoClient("localhost");
					
			DB db = mongoClient.getDB("test"); // test es la base de datos de pruebas
			
			boolean auth = db.authenticate("test", "test".toCharArray());
			if (auth) {
				DBCollection coll = db.getCollection("users"); // Nombre de la coleccion
				DBCursor cursor= coll.find(new BasicDBObject("name","joaquin"));
				while(cursor.hasNext()){
					//System.out.println(cursor.next());
					BasicDBObject obj = (BasicDBObject)cursor.next();
					User j= new User(obj.getString("name"),obj.getString("email"),obj.getString("password"),obj.getInt("dni"));
					System.out.println(j.getNombre());
				}
				System.out.println();
			} else {
				System.out.println("Fallo la autentificacion");			//Fallo la autentificacion igual esta deprecated, habria que mirar otro
			}
		} catch (Throwable e) {				//Catchs almost anything to this
			System.out.println("Excepcion " + e.getMessage());
		}
	}

}
