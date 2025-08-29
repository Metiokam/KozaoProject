package co.kozao.kotask.services.interfaces;

import java.sql.SQLException;
import java.util.List;

import co.kozao.kotask.models.ClientModel;

public interface ClientServiceInterface {
	
	ClientModel createClient(ClientModel clientModel)throws SQLException ;
	boolean updateClient(ClientModel clientModel)throws SQLException ;
	boolean deleteClient(int idClient)throws SQLException ;
	ClientModel getClientById(int idClient)throws SQLException;
    List<ClientModel> getALLClient() throws SQLException;
    

}
