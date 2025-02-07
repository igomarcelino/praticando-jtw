package com.igomarcelino.treinando_jwt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_role;

    public Roles() {
    }

    public Roles(Integer id_role, String role_name) {
        this.id_role = id_role;
        this.role_name = role_name;
    }

    private String role_name;

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return Objects.equals(id_role, roles.id_role) && Objects.equals(role_name, roles.role_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_role, role_name);
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id_role=" + id_role +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
