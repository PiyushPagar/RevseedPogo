package com.revnomix.revseed.model;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.revnomix.revseed.wrapper.PerformanceDto;
@NamedNativeQueries({
	@NamedNativeQuery(name="HistoryAndForecast.findHnFRevenueAndRoomAndClientByDate",
            query="SELECT room,revenue,otaName,date FROM (SELECT rooms_sold as room, revenue as revenue , 'WEBDIRECT' as otaName ,"
            		+ "date as date , ROW_NUMBER() OVER(PARTITION BY date  ORDER BY created_date DESC ) AS RowNumberRank \n"
            		+ "FROM history_and_forecast \n"
            		+ "WHERE client_id = :clientId AND `date` between :fromDate and :toDate) as a WHERE RowNumberRank = 1",
            resultClass = PerformanceDto.class,
            resultSetMapping = "HnfPerformanceDtoMapping"
    )
})
@SqlResultSetMappings({
    @SqlResultSetMapping(
            name = "HnfPerformanceDtoMapping",
            classes = {
                    @ConstructorResult(
                            targetClass = PerformanceDto.class,
                            columns = {
                                    @ColumnResult(name = "room", type = Integer.class),
                                    @ColumnResult(name = "revenue", type = BigDecimal.class),
                                    @ColumnResult(name = "date", type = Date.class),
                                    @ColumnResult(name = "otaName", type = String.class)
                            }
                    )
            }
    ),
})
@Entity
@Table (name = "history_and_forecast")
public class HistoryAndForecast extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column (name = "client_id")
    private Integer clientId;

    @Column (name = "hotel_id")
    private Integer hotelId;

    @Column(name = "date")
    private Date date;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "rooms_sold")
    private Integer roomsSold;

    @Column(name = "availability")
    private Integer availability;

    @Column(name = "revenue")
    private BigDecimal revenue;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getHotelId() { return hotelId; }

    public void setHotelId(Integer hotelId) { this.hotelId = hotelId; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public Integer getCapacity() { return capacity; }

    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Integer getRoomsSold() { return roomsSold; }

    public void setRoomsSold(Integer roomsSold) { this.roomsSold = roomsSold; }

    public Integer getAvailability() { return availability; }

    public void setAvailability(Integer availability) { this.availability = availability; }

    public BigDecimal getRevenue() { return revenue; }

    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }

}
