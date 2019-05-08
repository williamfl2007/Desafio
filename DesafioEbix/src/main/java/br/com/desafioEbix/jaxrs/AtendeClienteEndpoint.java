package br.com.desafioEbix.jaxrs;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

@Path("/")
public class AtendeClienteEndpoint {
	
	private static final String URL_WEBSERVICE = "https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl";
	
	@Path("/{cep}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public EnderecoERP getEndereco(@PathParam("cep") String cep) {
		
		try {			
			
		    URL url = new URL(URL_WEBSERVICE);
		    
		    QName qname = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/","AtendeCliente");

		    Service ws = Service.create(url,qname);
			 
			return ws.getPort(AtendeCliente.class).consultaCEP(cep);
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} catch (SigepClienteException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
