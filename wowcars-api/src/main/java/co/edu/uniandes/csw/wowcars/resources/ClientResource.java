/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.wowcars.resources;

import co.edu.uniandes.csw.auth.filter.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.wowcars.api.IClientLogic;
import co.edu.uniandes.csw.wowcars.dtos.detail.ClientDetailDTO;
import co.edu.uniandes.csw.wowcars.entities.ClientEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;



/**
 * URI: clients/
 * @generated
 */
@Path("/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {

    @Inject private IClientLogic clientLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de ClientEntity a una lista de ClientDetailDTO.
     *
     * @param entityList Lista de ClientEntity a convertir.
     * @return Lista de ClientDetailDTO convertida.
     * @generated
     */
    private List<ClientDetailDTO> listEntity2DTO(List<ClientEntity> entityList){
        List<ClientDetailDTO> list = new ArrayList<>();
        for (ClientEntity entity : entityList) {
            list.add(new ClientDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Client
     *
     * @return Colección de objetos de ClientDetailDTO
     * @generated
     */
    @GET
    public List<ClientDetailDTO> getClients() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", clientLogic.countClients());
            return listEntity2DTO(clientLogic.getClients(page, maxRecords));
        }
        return listEntity2DTO(clientLogic.getClients());
    }

    /**
     * Obtiene los datos de una instancia de Client a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de ClientDetailDTO con los datos del Client consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ClientDetailDTO getClient(@PathParam("id") Long id) {
        return new ClientDetailDTO(clientLogic.getClient(id));
    }

    /**
     * Se encarga de crear un Client en la base de datos
     *
     * @param dto Objeto de ClientDetailDTO con los datos nuevos
     * @return Objeto de ClientDetailDTOcon los datos nuevos y su ID
     * @generated
     */
    @POST
    @StatusCreated
    public ClientDetailDTO createClient(ClientDetailDTO dto) {
       
        return new ClientDetailDTO(clientLogic.createClient(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Client
     *
     * @param id Identificador de la instancia de Client a modificar
     * @param dto Instancia de ClientDetailDTO con los nuevos datos
     * @return Instancia de ClientDetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ClientDetailDTO updateClient(@PathParam("id") Long id, ClientDetailDTO dto) {
        ClientEntity entity = dto.toEntity();
        entity.setId(id);
        return new ClientDetailDTO(clientLogic.updateClient(entity));
    }

    /**
     * Elimina una instancia de Client de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteClient(@PathParam("id") Long id) {
        clientLogic.deleteClient(id);
    }
    


}
