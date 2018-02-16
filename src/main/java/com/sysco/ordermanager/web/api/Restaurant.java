package com.sysco.ordermanager.web.api;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Restaurant {

    private String id;

    @NotNull
    @Size(min=2, message="Name should have atleast 2 characters")
    private String address;
    @NotNull
    private UserDTO userDTO;


    public Restaurant() {
    }

    public Restaurant(String id, String address, UserDTO userDTO) {
        this.id = id;
        this.address = address;
        this.userDTO = userDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
