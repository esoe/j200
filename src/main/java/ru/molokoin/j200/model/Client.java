package ru.molokoin.j200.model;

import java.util.List;
import java.util.Objects;
import java.util.Date;

public class Client {
    private int clientid;
    private char[] client_name = new char[100];
    private char[] type = new char[20];
    private Date added;
    private List<Address> addresses;

    /**
     * @param clientid the clientid to set
     */
    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
    /**
     * @return the clientid
     */
    public int getClientid() {
        return clientid;
    }
    /**
     * @param client_name the client_name to set
     */
    public void setClient_name(char[] client_name) {
        this.client_name = client_name;
    }
    /**
     * @return the client_name
     */
    public char[] getClient_name() {
        return client_name;
    }
    /**
     * @param type the type to set
     */
    public void setType(char[] type) {
        this.type = type;
    }
    /**
     * @return the type
     */
    public char[] getType() {
        return type;
    }
    /**
     * @param added the added to set
     */
    public void setAdded(Date added) {
        this.added = added;
    }
    /**
     * @return the added
     */
    public Date getAdded() {
        return added;
    }
    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    /**
     * @return the addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client cli = (Client) o;
        return clientid == cli.clientid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientid);
    }
}
