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
package co.edu.uniandes.csw.wowcars.dtos.detail;

import co.edu.uniandes.csw.wowcars.dtos.minimum.*;
import co.edu.uniandes.csw.wowcars.entities.CarEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.ArrayList;
import co.edu.uniandes.csw.wowcars.entities.BrandEntity;
import co.edu.uniandes.csw.wowcars.entities.CategoryEntity;

import uk.co.jemos.podam.common.PodamExclude;

/**
 * @generated
 */
@XmlRootElement
public class CarDetailDTO extends CarDTO{



@PodamExclude
private BrandDTO brand;
@PodamExclude
private CategoryDTO category;


public CarDetailDTO() {
        super();
    }

 public CarDetailDTO(CarEntity entity) {
  super(entity); 
 if (entity.getBrand()!=null){
 this.brand = new BrandDTO(entity.getBrand());
 }
 if (entity.getCategory()!=null){
 this.category = new CategoryDTO(entity.getCategory());
 }
 }

   public CarEntity toEntity() {
  CarEntity entity = (CarEntity) super.toEntity();
   if (this.getBrand()!=null){
          entity.setBrand(this.getBrand().toEntity());
          }
   if (this.getCategory()!=null){
          entity.setCategory(this.getCategory().toEntity());
          }
  return entity;
  }

public BrandDTO getBrand() {
        return brand;
    }
 
    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }
public CategoryDTO getCategory() {
        return category;
    }
 
    public void setCategory(CategoryDTO category) {
        this.category = category;
    }


}
