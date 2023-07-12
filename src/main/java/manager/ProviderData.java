package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userModelListDTO(){
        // Data Transfer Object
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User()
                .withEmail("")
                .withPassword("")});
        list.add(new Object[]{new User()
                .withEmail("")
                .withPassword("")});
        list.add(new Object[]{new User()
                .withEmail("")
                .withPassword("")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>userModelListRegistrationDTO(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User()
                .withName("John")
                .withLastName("Doe")
                .withEmail("johndoe@gmail.com")
                .withPassword("Asdf1234")
        }); list.add(new Object[]{new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("johnsnow@gmail.com")
                .withPassword("Asdf1234")
        }); list.add(new Object[]{new User()
                .withName("John")
                .withLastName("Reagan")
                .withEmail("johnreagan@gmail.com")
                .withPassword("Asdf1234")
        });
        return list.iterator();
    }
}
