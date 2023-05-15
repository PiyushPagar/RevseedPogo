package com.revnomix.revseed.wrapper;


import java.io.Serializable;
import java.util.Date;

public class OverrideDetailsDto implements Serializable {

	private static final long serialVersionUID = 1L;


	public OverrideDetailsDto(){

    }
    private Integer id;
    private String active;
    private String algo;
    private String default_strategy;
    private Double default_rate;
    private Date checkin_date;
    private Date fromCheckin_date;
    private Date toCheckin_date;
    private int client_id;
    private String clientName;
    private int hotel_id;
    private String override_type;
    private float rate;
    private Date update_date;
    private int roomId;
    private Integer overridenBy;
    private boolean horizon;
    private Integer remarkId;
    private String remarkCode;
    private String remark;
    private Date overridedate;
    private String accountManager;


    public OverrideDetailsDto(Date checkin_date, float rate) {
        this.checkin_date = checkin_date;
        this.rate = rate;
    }

    public OverrideDetailsDto(Integer id, Integer hotel_id, Integer client_id, Integer room_id, Date overriden_date, Date checkin_date, String override_type, String override_algo, String active_override, float override_value,Integer overridenBy){
        this.id = id;
        this.hotel_id = hotel_id;
        this.client_id = client_id;
        this.roomId = room_id;
        this.update_date = overriden_date;
        this.checkin_date = checkin_date;
        this.override_type = override_type;
        this.algo = override_algo;
        this.active = active_override;
        this.rate = override_value;
        this.overridenBy = overridenBy;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String algo) {
        this.algo = algo;
    }

    public Date getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(Date checkin_date) {
        this.checkin_date = checkin_date;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getOverride_type() {
        return override_type;
    }

    public void setOverride_type(String override_type) {
        this.override_type = override_type;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Integer getId() {
        return id;
    }
    
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOverridenBy() {
		return overridenBy;
	}

	public void setOverridenBy(Integer overridenBy) {
		this.overridenBy = overridenBy;
	}

	public boolean getHorizon() {
		return horizon;
	}

	public void setHorizon(boolean horizon) {
		this.horizon = horizon;
	}

	public Integer getRemarkId() {
		return remarkId;
	}

	public void setRemarkId(Integer remarkId) {
		this.remarkId = remarkId;
	}

	public String getRemarkCode() {
		return remarkCode;
	}

	public void setRemarkCode(String remarkCode) {
		this.remarkCode = remarkCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getOverridedate() {
		return overridedate;
	}

	public void setOverridedate(Date overridedate) {
		this.overridedate = overridedate;
	}

	public String getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	public Date getFromCheckin_date() {
		return fromCheckin_date;
	}

	public void setFromCheckin_date(Date fromCheckin_date) {
		this.fromCheckin_date = fromCheckin_date;
	}

	public Date getToCheckin_date() {
		return toCheckin_date;
	}

	public void setToCheckin_date(Date toCheckin_date) {
		this.toCheckin_date = toCheckin_date;
	}

	public String getDefault_strategy() {
		return default_strategy;
	}

	public void setDefault_strategy(String default_strategy) {
		this.default_strategy = default_strategy;
	}

	public Double getDefault_rate() {
		return default_rate;
	}

	public void setDefault_rate(Double default_rate) {
		this.default_rate = default_rate;
	}
	
	
	
}
