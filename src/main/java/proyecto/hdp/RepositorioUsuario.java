/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.hdp;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author UriDrack7
 */
public interface RepositorioUsuario extends MongoRepository<Usuario, String> {
    
}
