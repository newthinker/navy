package cn.com.hd.dto.navy;

import java.sql.Blob;

import cn.com.hd.service.BaseDTO;

/**
 * TImage entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TImage extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/* id */
	private String imageid;

	/* property */
	private String importid;
	private String imagetypeid;
	private String imagetype;
	private String imagename;
	private String imagedesc;
	private String imagepath;
	private Integer imageorder;
	private Blob image;
	private String expinfoa;
	private String expinfob;
	private String expinfoc;
	private String expinfod;
	private String expinfoe;

	public void setImageid(String imageid) {
		this.imageid = imageid;
	}

	public void setImportid(String importid) {
		this.importid = importid;
	}

	public void setImagetypeid(String imagetypeid) {
		this.imagetypeid = imagetypeid;
	}

	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public void setImagedesc(String imagedesc) {
		this.imagedesc = imagedesc;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public void setExpinfoa(String expinfoa) {
		this.expinfoa = expinfoa;
	}

	public void setExpinfob(String expinfob) {
		this.expinfob = expinfob;
	}

	public void setExpinfoc(String expinfoc) {
		this.expinfoc = expinfoc;
	}

	public void setExpinfod(String expinfod) {
		this.expinfod = expinfod;
	}

	public void setExpinfoe(String expinfoe) {
		this.expinfoe = expinfoe;
	}

	public String getImageid() {
		return imageid;
	}

	public String getImportid() {
		return importid;
	}

	public String getImagetypeid() {
		return imagetypeid;
	}

	public String getImagetype() {
		return imagetype;
	}

	public String getImagename() {
		return imagename;
	}

	public String getImagedesc() {
		return imagedesc;
	}

	public String getImagepath() {
		return imagepath;
	}

	public Blob getImage() {
		return image;
	}

	public String getExpinfoa() {
		return expinfoa;
	}

	public String getExpinfob() {
		return expinfob;
	}

	public String getExpinfoc() {
		return expinfoc;
	}

	public String getExpinfod() {
		return expinfod;
	}

	public String getExpinfoe() {
		return expinfoe;
	}

	public Integer getImageorder() {
		return imageorder;
	}

	public void setImageorder(Integer imageorder) {
		this.imageorder = imageorder;
	}

}