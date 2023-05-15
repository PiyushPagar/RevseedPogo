package com.revnomix.revseed.model;

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

import com.revnomix.revseed.wrapper.OverrideFinalDto;

import lombok.Data;

@NamedNativeQueries({
    @NamedNativeQuery(
            name = "RecommendationsToShow.getRecommendationtoShow",
            query = " SELECT id,hotel_id,client_id,room_id,updated_date,checkin_date,final_rate,strategy FROM revseed.recommendations_to_show WHERE client_id = :clientId "
            		+ "AND checkin_date >= :startDate AND checkin_date <= :endDate ",
            resultClass= OverrideFinalDto.class,
            resultSetMapping = "RecommendationsToShowDtoMapping"
    )
})

@SqlResultSetMappings({
    @SqlResultSetMapping(
            name = "RecommendationsToShowDtoMapping",
            classes = {
                    @ConstructorResult(
                            targetClass = OverrideFinalDto.class,
                            columns = {
                                    @ColumnResult(name = "id", type = Integer.class),
                                    @ColumnResult(name = "hotel_id", type = Integer.class),
                                    @ColumnResult(name = "client_id", type = Integer.class),
                                    @ColumnResult(name = "room_id", type = Integer.class),
                                    @ColumnResult(name = "updated_date", type = Date.class),
                                    @ColumnResult(name = "checkin_date", type = Date.class),
                                    @ColumnResult(name = "final_rate",type = Float.class),
                                    @ColumnResult(name = "strategy",type = String.class),
                            }
                    )
            }
    ),
})
@Data
@Entity
@Table(name = "recommendations_to_show")
public class RecommendationsToShow extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "client_id")
    private Long clientId;
	
	@Column(name = "hotel_id")
    private Long hotelId;
	
	@Column(name = "room_id")
    private Long roomId;
	
	@Column(name = "checkin_date")
	private Date checkinDate;
	
	@Column(name = "final_rate")
	private Double finalRate;
	
	@Column(name = "strategy", length = 20)
	private String strategy;
	
	@Column(name = "push_rate")
	private Boolean isRatePush;
}
