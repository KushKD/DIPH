package com.dit.himachal.entities;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "mst_vehicle_owner_documents")
public class VehicleOwnerDocuments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 200025910641328289L;
	
	@Id
	@GeneratedValue(generator = "mst_vehicle_owner_documents_doc_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "mst_vehicle_owner_documents_doc_id_seq", sequenceName = "public.mst_vehicle_owner_documents_doc_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "doc_id")
	private Long docId;

	@Column(name = "vehicle_owner_id")
	private Integer vehicleOwnerId;
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	@Column(name="vehicle_image_owner")
	private byte[] vehicleImageOwner;
	
	@Column(name = "uploaded_by")
	private Integer uploadedBy;
	
	@Column(name = "filetype")
	private String fileType;
	
	@Column(name = "file_extention")
	private String fileExtention;
	
	@Column(name = "active")
	private boolean active;

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Integer getVehicleOwnerId() {
		return vehicleOwnerId;
	}

	public void setVehicleOwnerId(Integer vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
	}

	public byte[] getVehicleImageOwner() {
		return vehicleImageOwner;
	}

	public void setVehicleImageOwner(byte[] vehicleImageOwner) {
		this.vehicleImageOwner = vehicleImageOwner;
	}

	public Integer getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(Integer uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileExtention() {
		return fileExtention;
	}

	public void setFileExtention(String fileExtention) {
		this.fileExtention = fileExtention;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "VehicleOwnerDocuments [docId=" + docId + ", vehicleOwnerId=" + vehicleOwnerId + ", vehicleImageOwner="
				+ Arrays.toString(vehicleImageOwner) + ", uploadedBy=" + uploadedBy + ", fileType=" + fileType
				+ ", fileExtention=" + fileExtention + ", active=" + active + "]";
	}
	
	
	
	
	
	
	
	

}
