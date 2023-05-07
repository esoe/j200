package ru.molokoin.j200.model;

import java.util.Objects;

/**
 * Класс - модель, описывает адрес клиента
 * ! все поля не могут быть пустыми (так понимаю - пустых полей не может быть)
 */
public class Address {
    /**
     * IP адрес состоит из четырех октетов разделенных точкой, каждый октет имеет размер не более трех чисел, числа должны быть в диапазоне от 0 до 255, например: 192.168.000.001
     */
    private char[] ip;// char[25]
    /**
     * MAC-адрес состоит из шести октетов разделенных символом «-». Каждый октет имеет размер не более двух символов и состоит из чисел и/или букв латинского алфавита.
     */
    private char[] mac;// char[20]
    private char[] model;// char[100]
    private char[] address;// char[100]
    private Client client;// адрес не может быть не привязан к клиенту

    public Address(char[] ip, char[] mac, char[] model, char[] address, Client client){
        this.ip = ip;
        this.mac = mac;
        this.model = model;
        this.address = address;
        this.client = client;
    }
    public void setIp(char[] ip) {
        this.ip = ip;
    }
    public char[] getIp() {
        return ip;
    }
    public void setMac(char[] mac) {
        this.mac = mac;
    }
    public char[] getMac() {
        return mac;
    }
    public void setModel(char[] model) {
        this.model = model;
    }
    public char[] getModel() {
        return model;
    }
    public void setAddress(char[] address) {
        this.address = address;
    }
    public char[] getAddress() {
        return address;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Client getClient() {
        return client;
    }
    
    /**
     * Сравнение происходит по мак адресу,
     * это вроде как уникальный идентификатор железа с которого пользователь заходит в сеть.
     * Хотя  и есть техническая возможность сменить mac-адрес устройства, отобразаемый в сети.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return mac == address.mac;
    }

    /**
     * предполагаем, что mac-адрес является уникальным идентификатором устройства в сети
     */
    @Override
    public int hashCode() {
        return Objects.hash(mac);
    }

}
