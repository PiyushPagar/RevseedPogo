package com.revnomix.revseed.wrapper;

import com.revnomix.revseed.model.Clients;

import java.util.List;

public class ClientsDto {

    public List<com.revnomix.revseed.model.Clients> getClients() {
        return clients;
    }

    public void setClients(List<com.revnomix.revseed.model.Clients> clients) {
        this.clients = clients;
    }

    private List<com.revnomix.revseed.model.Clients> clients;

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    private Integer totalRows;

    public ClientsDto(List<Clients> clients, Integer totalRows) {
        this.clients = clients;
        this.totalRows = totalRows;
    }
}
