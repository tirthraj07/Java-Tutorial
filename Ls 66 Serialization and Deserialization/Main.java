// Serialization and Deserialization in Java

// Source: https://www.tpointtech.com/serialization-in-java

/*

Serialization in Java is a mechanism for writing an object's state into a byte stream, making it easier to store or send over a network. 
It is mainly used in Hibernate, RMI, JPA, EJB, and JMS technologies.
The reverse operation of serialization is called deserialization, where the byte stream is converted into an object. 

The serialization and deserialization process is PLATFORM INDEPENDENT. 

It means we can serialize an object on one platform and deserialize it on a different platform.

For serializing the object, we call the writeObject() method of the ObjectOutputStream class. 
For deserialization, we call the readObject() method of the ObjectInputStream class.

Advantages of Java Serialization
1. Platform Independence: There are no compatibility problems when transferring serialized objects between separate Java virtual machines (JVMs) running on different platforms. Java Serialization is an effective technique for inter-system communication because of its platform independence.
2. Network Communication: Java Serialization facilitates the transmission of object data over a network. This process, known as marshalling, allows objects to be serialized into a byte stream and sent across a network to be reconstructed on another machine. It is crucial for applications involving distributed systems, such as client-server architectures and web services.
3. Object Persistence: Serialization allows for indefinite storage of object state. Data can be kept between program executions by using serialized objects, which can be saved to a disc or a database and then retrieved.

Which data aren’t serializable:

1. Non-Serializable Classes: Any class that does not implement the Serializable interface cannot be serialized
2. Static Fields: Static members belong to the class rather than to an instance, so they are not part of an object’s state and are never serialized.
3. Transient Fields: Fields declared with the transient keyword are explicitly excluded from serialization. This is often used for sensitive data (like passwords) or data that can be recalculated.
4. Objects with Non-Serializable Members: Even if a class implements Serializable, if it holds a reference to another object that isn’t serializable, serialization will fail unless that field is marked as transient or handled with custom serialization logic.
5. Certain System Resources: Objects representing system resources (such as file handles, database connections, threads, or sockets) are not serializable because they represent a runtime context rather than persistent data.

**serialVersionUID**

The serialVersionUID is a special field in a Java class that implements the Serializable interface. It acts as a version identifier for the class during serialization and deserialization. In simpler terms, it tells the JVM, “This is version X of my class,” so that when an object is deserialized later, Java can verify that the class structure is compatible with the one used when the object was serialized.

When you serialize an object (convert it into a byte stream), Java records the class’s serialVersionUID with that data. When you later deserialize the object (convert the byte stream back to an object), the JVM checks that the serialVersionUID of the class matches the one stored in the serialized data. If they don’t match, you get an InvalidClassException

Why Define It Manually?
If you don’t explicitly define a serialVersionUID, Java generates one based on your class’s details (like fields, methods, etc.). 
This auto-generated ID can change if you modify your class—even in minor ways—which may unintentionally break serialization compatibility. 
By declaring it manually, you have control over versioning and can maintain backward compatibility when you make non-breaking changes.

When to Change It:
If you modify your class in a way that is not compatible with previous serialized versions (for example, by removing fields or changing data types), you should update the serialVersionUID.


*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String[] qualifications;
    private String email;
    private transient String password;

    public Person(String name, String email, String password, int age, String[] qualifications) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        StringBuilder obj = new StringBuilder();
        obj.append("Name : " + name);
        obj.append("\nEmail: " + email);
        obj.append("\nPassword: " + password);
        obj.append("\nAge: " + age);
        obj.append("\nQualifications: ");
        for (String qualification : qualifications) {
            obj.append(qualification + " ");
        }
        return obj.toString().trim();
    }

}

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Tirthraj", "tirthraj@gmail.com", "tirthraj123", 20, new String[] { "SSC", "HSC", "BE" });

        System.out.println("== BEFORE SEREALIZATION AND DESEREALIZATION ==");
        System.out.println(person);

        // Serialization
        try (
                FileOutputStream fos = new FileOutputStream("employee.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(person);
        } catch (Exception e) {
            System.out.println("Error occurred while Serializing the Object");
        }

        System.out.println("\n\n== AFTER SEREALIZATION AND DESEREALIZATION ==");

        // Deserialization
        try (
                FileInputStream fis = new FileInputStream("employee.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println(deserializedPerson);
        } catch (Exception e) {
            System.out.println("Error occurred while deserializing the Object");
        }


        /*
        OUTPUT:

        == BEFORE SEREALIZATION AND DESEREALIZATION ==
        Name : Tirthraj
        Email: tirthraj@gmail.com
        Password: tirthraj123
        Age: 20
        Qualifications: SSC HSC BE


        == AFTER SEREALIZATION AND DESEREALIZATION ==
        Name : Tirthraj
        Email: tirthraj@gmail.com
        Password: null
        Age: 20
        Qualifications: SSC HSC BE
        */


    }
}
