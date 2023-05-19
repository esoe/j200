package ru.molokoin.j200.models;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Date;
/**
 * Класс - модель, описывает сведения о клиенте
 * - все поля не могут быть пустыми! (не очень понятно что это значит, предположим, что вообще не может быть пустых полей).
 */
public class Client {
    private int client_id;
    /**
     * Поле наименование 
     * допустимо использование только русского алфавита, а также символов {- ,.}
     */
    private char[] client_name;// char[100]
    /**
     * Для поля type допустимы значения:
     * - Юридическое лицо
     * - Физическое лицо
     */
    private char[] type;// char[20]
    /**
     * дата добавления клиента по хорошему должна всегда являться текущей датой (при внесении данных), однако в реальных условиях использования подобных приложений - зачастую требуется внести какие-либо данные задним числом.
     */
    private Date added;// дата добавления клиента
    private List<Address> addresses;// список адресов клиента, может быть пустым

    public Client(){
        addresses = new ArrayList<>();
    }

    public Client(int client_id, char[] client_name, char[] type, Date added){
        this();
        this.client_id = client_id;
        this.client_name = client_name;
        this.type = type;
        this.added = added;
    }

    /**
     * @param clientid the clientid to set
     */
    public void setClientid(int clientid) {
        this.client_id = clientid;
    }
    /**
     * @return the clientid
     */
    public int getClientid() {
        return client_id;
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
        return client_id == cli.client_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(client_id);
    }
}
