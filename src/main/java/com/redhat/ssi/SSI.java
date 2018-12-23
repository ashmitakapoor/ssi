package com.redhat.ssi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "ssi")
public class SSI {
	
	@Id
	@ApiModelProperty(notes = "The database generated product ID")
    private String id;
	@ApiModelProperty(notes = "SSI Name")
	private String ssiName;
	@ApiModelProperty(notes = "Currency Code")
	private String currencyCode;
	@ApiModelProperty(notes = "Place of Settlement Code")
	private String posCode;
	@ApiModelProperty(notes = "Asset Class Code")
    private String assetclassCode;
	@ApiModelProperty(notes = "Transaction Sub Type Code")
    private String transSubTypeCode;
	@ApiModelProperty(notes = "Buyer/Seller ID Type")
    private String bsIdType;
	@ApiModelProperty(notes = "Buyer/Seller ID")
    private int bsId;
	@ApiModelProperty(notes = "Buyer/Seller Name")
    private String bsNameAdd;
	@ApiModelProperty(notes = "Buyer/Seller Account")
    private String bsAcc;
    @ApiModelProperty(notes = "Rec Del ID Type")
    private String rdaIdType;
    @ApiModelProperty(notes = "Rec Del ID")
    private int rdaId;
    @ApiModelProperty(notes = "Rec Del Name")
    private String rdaNameAdd;
    @ApiModelProperty(notes = "Rec Del Account")
    private String rdaAcc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSsiName() {
		return ssiName;
	}
	public void setSsiName(String ssiName) {
		this.ssiName = ssiName;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getPosCode() {
		return posCode;
	}
	public void setPosCode(String posCode) {
		this.posCode = posCode;
	}
	public String getAssetclassCode() {
		return assetclassCode;
	}
	public void setAssetclassCode(String assetclassCode) {
		this.assetclassCode = assetclassCode;
	}
	public String getTransSubTypeCode() {
		return transSubTypeCode;
	}
	public void setTransSubTypeCode(String transSubTypeCode) {
		this.transSubTypeCode = transSubTypeCode;
	}
	public String getBsIdType() {
		return bsIdType;
	}
	public void setBsIdType(String bsIdType) {
		this.bsIdType = bsIdType;
	}
	public int getBsId() {
		return bsId;
	}
	public void setBsId(int bsId) {
		this.bsId = bsId;
	}
	public String getBsNameAdd() {
		return bsNameAdd;
	}
	public void setBsNameAdd(String bsNameAdd) {
		this.bsNameAdd = bsNameAdd;
	}
	public String getBsAcc() {
		return bsAcc;
	}
	public void setBsAcc(String bsAcc) {
		this.bsAcc = bsAcc;
	}
	public String getRdaIdType() {
		return rdaIdType;
	}
	public void setRdaIdType(String rdaIdType) {
		this.rdaIdType = rdaIdType;
	}
	public int getRdaId() {
		return rdaId;
	}
	public void setRdaId(int rdaId) {
		this.rdaId = rdaId;
	}
	public String getRdaNameAdd() {
		return rdaNameAdd;
	}
	public void setRdaNameAdd(String rdaNameAdd) {
		this.rdaNameAdd = rdaNameAdd;
	}
	public String getRdaAcc() {
		return rdaAcc;
	}
	public void setRdaAcc(String rdaAcc) {
		this.rdaAcc = rdaAcc;
	}
	
	
}