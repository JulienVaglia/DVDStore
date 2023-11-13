
import  com.simplon.dvdstore.*;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//Run With : ce qui permet de lancer le processus de test dans mon serveur
@RunWith(SpringRunner.class)
//Configuration : librairie de test, Classe application (main)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DvdstoreApplication.class)
// quand j'utilise Mock
@AutoConfigureMockMvc
// application properties. Le mieux c'est d'avoir un autre application properties pour les tests dans les ressources
@TestPropertySource(
        locations = "classpath:application.properties")
public class DvdStoreServiceTest {

    // Ce que je teste; l'alternative est de le mocker(simuler une classe qui dure le temps de son utilisation)
    @Autowired
    private DvdStoreService dvdStoreService;




    //je créer un dvdServiceModel avec lequel je fais le test
    private DvdServiceModel createDvdServiceModel(String name, String genre) {
        return new DvdServiceModel(name, genre);
    }


    //Le premier test unitaire
    @Test
    //nom de la fonction que je teste_valeur de retour attendue_en fonction des parametres
    public void add_dvd_returns_true()
            throws Exception {


        //fonctions de test unitaires par assert
        assertTrue(dvdStoreService.add(createDvdServiceModel("Matrix", "Science-Fiction")));


       /* pour test un get
       assertEquals(dvdStoreService.getDvd(1), createDvdServiceModel("matrix","sci-fi"));
       */
    }


    // je teste toutes les possibilités auxquelles je peux penser
    @Test
    public void add_dvd_returns_false_if_property_name_is_null()
            throws Exception {


        assertFalse(dvdStoreService.add(createDvdServiceModel(null,"Science-Fiction")));
    }


    @Test
    public void add_dvd_returns_false_if_property_genre_is_null()
            throws Exception {


        assertFalse(dvdStoreService.add(createDvdServiceModel("Matrix",null)));
    }


    @Test
    public void add_dvd_returns_false_if_property_genre_and_property_name_is_null()
            throws Exception {


        assertFalse(dvdStoreService.add(createDvdServiceModel(null,null)));
    }




    // write test cases here
}






