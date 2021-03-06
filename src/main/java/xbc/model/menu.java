package xbc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_menu")
public class Menu implements Serializable {
//	Id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, nullable=false, columnDefinition = "serial")
	private Integer id;

// 	Input	
//	@Column(name="code", length=50, nullable=false)
	@Column(name="code", length=50)
	private String code;
	
	@Column(name="title", length= 50, nullable=false)
	private String title;
	
	@Column(name="description", length=255)
	private String description;
	
	@Column(name="image_url", length=100)
	private String imageUrl;
	
	@Column(name="menu_order", nullable=false)
	private Integer menuOrder;
	
	@ManyToOne
	@JoinColumn(name="menu_parent", updatable=false, insertable=false)
	private Menu menuParentMenu;
	
	@Column(name="menu_parent", length=11)
	private Integer menuParent;
	
	@Column(name="menu_url", length=100, nullable=false)
	private String menuUrl;
	
//	Waktu	
	@Column(name="created_on", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date createdOn;
	
	@Column(name="modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date modifiedOn;
	
	@Column(name="delete_on")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Jakarta")
	private Date deleteOn;

//	Modify	
	@Column(name="delete_by", length=11)
	private Integer deleteBy;
	
	@Column(name="create_by", length=11, nullable=false)
	private Integer createBy;
	
	@Column(name="modified_by", length=11)
	private Integer modifiedBy;
	
	@Column(name="is_delete", nullable=false)
	private boolean isDelete;

	public Integer getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public Menu getMenuParentMenu() {
		return menuParentMenu;
	}

	public Integer getMenuParent() {
		return menuParent;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public Integer getDeleteBy() {
		return deleteBy;
	}

	public Date getDeleteOn() {
		return deleteOn;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	public void setMenuParentMenu(Menu menuParentMenu) {
		this.menuParentMenu = menuParentMenu;
	}

	public void setMenuParent(Integer menuParent) {
		this.menuParent = menuParent;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public void setDeleteBy(Integer deleteBy) {
		this.deleteBy = deleteBy;
	}

	public void setDeleteOn(Date deleteOn) {
		this.deleteOn = deleteOn;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
}
