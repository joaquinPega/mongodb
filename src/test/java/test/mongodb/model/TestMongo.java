package test.mongodb.model;

import java.security.MessageDigest;

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
			User user = new User("joaquin","joaquin_pega@hotmail.com","pass",33654296);
			DB db = mongoClient.getDB("test"); // test es la base de datos de pruebas
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String text = "asd";

			md.update(text.getBytes()); 
			byte[] digest= md.digest();
			StringBuffer sb = new StringBuffer();
		    for (int i = 0; i < digest.length; i++) {
		    	sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
		    }
			System.out.println(sb.toString());
			user.setPassword(sb.toString());
			boolean auth = db.authenticate("test", "test".toCharArray());
			if (auth) {
				DBCollection coll = db.getCollection("users"); // Nombre de la coleccion
				BasicDBObject doc = new BasicDBObject("name",user.getNombre())
				.append("password", user.getPassword())
				.append("email", user.getMail())
				.append("dni", user.getDni());
				coll.insert(doc);
			} else {
				System.out.println("Fallo la autentificacion");			//Fallo la autentificacion igual esta deprecated, habria que mirar otro
			}
		} catch (Throwable e) {				//Catchs almost anything to this
			System.out.println("Excepcion " + e.getMessage());
		}
	}

}
