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
package co.edu.uniandes.csw.wowcars.dtos.minimum;

import co.edu.uniandes.csw.wowcars.entities.ClientEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @generated
 */
@XmlRootElement
public class ClientDTO  implements Serializable{


private Long id;
private String name;
private String email;
private Long phone;

 

    public ClientDTO() {
    }


public ClientDTO(ClientEntity entity) {
   if (entity!=null){
    this.name=entity.getName();
    this.email=entity.getEmail();
    this.phone=entity.getPhone();
       }
    }
    


 public ClientEntity toEntity() {
        ClientEntity entity = new ClientEntity();
        entity.setName(this.getName());
        entity.setEmail(this.getEmail());
        entity.setPhone(this.getPhone());
         return entity;
       }
       


    
    public  Long getId() {
        return id;
    }
  
    public void setId( Long id) {
        this.id = id;
    }

    
    public  String getName() {
        return name;
    }
  
    public void setName( String name) {
        this.name = name;
    }

    
    public  String getEmail() {
        return email;
    }
  
    public void setEmail( String email) {
        this.email = email;
    }

    
    public  Long getPhone() {
        return phone;
    }
  
    public void setPhone( Long phone) {
        this.phone = phone;
    }

}
