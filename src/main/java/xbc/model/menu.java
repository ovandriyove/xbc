package xbc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_menu")
public class Menu implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, nullable=false)
	private long id;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="code", length=50, nullable=false)
	private String code;
	
	@Column(name="title", length= 50, nullable=false)
	private String title;
	
	@Column(name="description", length=255)
	private String description;
	
	@Column(name="image_url", length=100)
	private String imageUrl;
	
	@Column(name="menu_order", nullable=false)
	private long menuOrder;
	
	@Column(name="menu_parent", length=11)
	private long menuParent;
	
	@Column(name="menu_url", length=100, nullable=false)
	private String menuUrl;
	
	@Column(name="create_by", length=11, nullable=false)
	private long createBy;
	
	@Column(name="created_on", nullable=false)
	private Date createdOn;
	
	@Column(name="modified_by", length=11)
	private long createdBy;
	
	@Column(name="modified_on")
	private Date modifiedOn;
	
	@Column(name="delete_by", length=11)
	private long deleteBy;
	
	@Column(name="delete_on")
	private Date deleteOn;
	
	@Column(name="is_delete", nullable=false, columnDefinition="default boolean false")
	private boolean isDelete;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public long getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(long menuOrder) {
		this.menuOrder = menuOrder;
	}

	public long getMenuParent() {
		return menuParent;
	}

	public void setMenuParent(long menuParent) {
		this.menuParent = menuParent;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(long createBy) {
		this.createBy = createBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public long getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(long deleteBy) {
		this.deleteBy = deleteBy;
	}

	public Date getDeleteOn() {
		return deleteOn;
	}

	public void setDeleteOn(Date deleteOn) {
		this.deleteOn = deleteOn;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
}
