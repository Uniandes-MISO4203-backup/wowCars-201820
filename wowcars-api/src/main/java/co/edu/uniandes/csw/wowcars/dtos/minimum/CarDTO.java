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

import co.edu.uniandes.csw.wowcars.entities.CarEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @generated
 */
@XmlRootElement
public class CarDTO  implements Serializable{


private Long id;
private String name;
private String image;
private Long price;
private Long revisions;
private Long warranty;

 

    public CarDTO() {
    }


public CarDTO(CarEntity entity) {
   if (entity!=null){
    this.name=entity.getName();
    this.image=entity.getImage();
    this.price=entity.getPrice();
    this.revisions=entity.getRevisions();
    this.warranty=entity.getWarranty();
       }
    }
    


 public CarEntity toEntity() {
        CarEntity entity = new CarEntity();
        entity.setName(this.getName());
        entity.setImage(this.getImage());
        entity.setPrice(this.getPrice());
        entity.setRevisions(this.getRevisions());
        entity.setWarranty(this.getWarranty());
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

    
    public  String getImage() {
        return image;
    }
  
    public void setImage( String image) {
        this.image = image;
    }

    
    public  Long getPrice() {
        return price;
    }
  
    public void setPrice( Long price) {
        this.price = price;
    }

    
    public  Long getRevisions() {
        return revisions;
    }
  
    public void setRevisions( Long revisions) {
        this.revisions = revisions;
    }

    
    public   Long getWarranty() {
        return warranty;
    }
  
    public void setWarranty(Long warranty) {
        this.warranty = warranty;
    }

}
