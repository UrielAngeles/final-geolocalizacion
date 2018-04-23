/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.hdp;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author UriDrack7
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ControladorUsuario {
    
    //Aqui viene las 5 operaciones basicas
    @Autowired RepositorioUsuario repo;
    
    //Metodo para guardar
    @RequestMapping(value="/usuario", method = RequestMethod.POST , headers = {"Accept=application/json"})
    public Estatus guardar(@RequestBody String json)throws Exception{
    
        ObjectMapper maper= new ObjectMapper();
        Usuario u= maper.readValue(json, Usuario.class);
        
        Estatus e=new Estatus();
        
        repo.save(u);
        e.setSuccess(true);
        return e;
    }
    
        //Borrar
    @CrossOrigin
    @RequestMapping(value="/usuario/{Id}", method= RequestMethod.DELETE, 
            headers={"Accept=application/json"})
    public Estatus borrarMensaje(@PathVariable String Id){
    
        Estatus estatus=new Estatus(true, "Borrado con Exito");
        repo.delete(new Usuario(Id));
        
        return estatus;
    }
    
    //Buscar Todos
    @CrossOrigin
    @RequestMapping(value = "/mensajito",method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    public ArrayList<Usuario> hola(){
      
        return(ArrayList<Usuario>) repo.findAll(); 
    }
    
    //Buscar por ID
    @CrossOrigin
    @RequestMapping(value = "/mensajito/{Id}",method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    public Usuario hola(@PathVariable String Id){
      
        return repo.findOne(Id); 
    }
    
    //Actualizar
    @CrossOrigin
    @RequestMapping(value="/usuario/{Id}/{titulo}/{cuerpo}",method=RequestMethod.PUT,
            headers={"Accept=application/json"})
    
    public Estatus actualizar(@PathVariable String Id,@PathVariable String titulo, @PathVariable String cuerpo){
        repo.save(new Usuario(Id, titulo,cuerpo));
        return new Estatus(true, "Actualizado con exito");
    }
}