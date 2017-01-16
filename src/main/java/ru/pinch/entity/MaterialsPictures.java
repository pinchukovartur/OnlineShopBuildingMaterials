package ru.pinch.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photoconstructionmaterials", schema = "buildingonlineshop", catalog = "")
public class MaterialsPictures {
    private String photo;
    private int id_photo;
    /*private Material material;*/

    @Id
    @Column(name = "Photo", nullable = false, length = 45)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "id_photo", nullable = false, length = 45)
    public int getId_photo() {
        return id_photo;
    }

    public void setId_photo(int id_photo) {
        this.id_photo = id_photo;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialsPictures that = (MaterialsPictures) o;

        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return photo != null ? photo.hashCode() : 0;
    }
}
