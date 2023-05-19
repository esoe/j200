package ru.molokoin.j200.entities;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.xml.bind.annotation.XmlRootElement;
/**
 * Класс сущности, связанный с таблицей Addresses.
 * Используется вместо одноименного класса-модели
 */
@Entity
/**
 * Указали наименование таблицы в базе.
 * -не понятно, обязательно ли должна быть создана таблица, заранее.
 */
@Table(name = "Addresses")
@XmlRootElement
// @NamedQueries({
//     @NamedQuery(name = "Addresses.findAll", query = "SELECT a FROM Addresses a")
//     , @NamedQuery(name = "Addresses.findById", query = "SELECT a FROM Addresses a WHERE a.id = :id")
//     , @NamedQuery(name = "Addresses.findByIp", query = "SELECT a FROM Addresses a WHERE a.ip = :ip")
//     })
public class Address implements Serializable{
    @Id //уникальный идентификатор строки
    @GeneratedValue(strategy = GenerationType.IDENTITY)//автоматически-генерируемые значения поля
    @Basic(optional = false) //не может быть null
    @Column(name = "id") //наименование столбца в таблице, с которым проасоциировано поле
    private Integer id;

    /**
     * IP адрес состоит из четырех октетов разделенных точкой, каждый октет имеет размер не более трех чисел, числа должны быть в диапазоне от 0 до 255, например: 192.168.000.001
     */
    @Column(name = "ip", length = 15)
    private String ip;

    /**
     * MAC-адрес состоит из шести октетов разделенных символом «-». Каждый октет имеет размер не более двух символов и состоит из чисел и/или букв латинского алфавита.
     */
    @Column(name = "mac", length = 17)
    private String mac;

    @Column(name = "model", length = 100)// char[100]
    private String model;

    @Column(name = "address", length = 100)// char[100]
    private String address;

    @Basic(optional = false) //не может быть null : адрес не может быть не привязан к клиенту
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client_id;
    /**
     * Главный конструктор, без него ничего не будет работать
     */
    public Address(){}
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getIp() {
        return ip;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getMac() {
        return mac;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }
    public Client getClient_id() {
        return client_id;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Address [id=" + id + ", ip=" + ip + ", mac=" + mac + ", model=" + model + ", address=" + address + "]";
    }
}
