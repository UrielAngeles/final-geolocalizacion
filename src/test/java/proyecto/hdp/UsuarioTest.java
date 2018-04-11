package proyecto.hdp;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {
@Autowired RepositorioUsuario repo;

	@Test
	public void contextLoads() {
	}
        
    	@Test
	public void guardar() {
            
            //Aqui ponemos la logica de guardar un usuario
            //Generamos un objeto
            Usuario u=new Usuario();
            Posicion pos=new Posicion();
            Mensaje mensa=new Mensaje();
            
            //Generar un usuario con todos sus atributos, incluyendo un mensaje y posicion
            //Pág 30 del libro
            
            pos.setLat(19.90);
            pos.setLon(100.0);
            
            mensa.setContenido("Primer Contenido");
            u.setMail("urielangeles96@gmail.com");
            ArrayList<Mensaje>mensajes=new ArrayList<>();
            mensajes.add(mensa);
            u.setMensajes(mensajes);
            u.setPassword("cr7");
            u.setNickname("UriDrack7");
            u.setPosicion(pos);
            u.setId("Primero");
            //Guardamos
            Usuario guardado= repo.save(u);
            Assert.assertEquals(guardado,u);
            }
        
        @Test
	public void actualizar() {
            
            
            
            
	}
        
        @Test
	public void borrar() {
            
            
            
            
	}
        
        @Test
	public void buscarTodo() {
          //int tamano=  repo.findAll().size();
            //Assert.assertEquals(1, tamano);
            
           Usuario encontrado= repo.findAll().get(0);
           Assert.assertEquals("Primero", encontrado.getId());
	}

        @Test
	public void buscarPorId() {
        Usuario usuarioBuscado= repo.findById("Primero").get();
        Assert.assertEquals("Primero",usuarioBuscado.getId());
	}
}
