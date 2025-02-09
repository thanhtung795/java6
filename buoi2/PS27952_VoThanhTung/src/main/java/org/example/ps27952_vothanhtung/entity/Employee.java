package org.example.ps27952_vothanhtung.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @NotBlank(message = "Mã nhân viên không được để trống")
    @Size(max = 10, message = "Mã nhân viên không được quá 10 ký tự")
    @Column(name = "maNV", nullable = false)
    private String maNV;

    @NotBlank(message = "Họ và tên không được để trống")
    @Size(max = 50, message = "Họ và tên không được quá 50 ký tự")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Giới tính không được để trống")
    @Column(name = "gender", nullable = false)
    private Boolean gender;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 100, message = "Địa chỉ không được quá 100 ký tự")
    @Column(name = "address", nullable = false)
    private String address;

}