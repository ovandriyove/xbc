package xbc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_menu")
public class menu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, nullable=false)
	private Number id;
	
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
	private Number menuOrder;
	
	@Column(name="menu_parent", length=11)
	private Number menuParent;
	
	@Column(name="menu_url", length=100, nullable=false)
	private String menuUrl;
	
	@Column(name="create_by", length=11, nullable=false)
	private Number createBy;
	
	@Column(name="created_on", nullable=false)
	private Date createdOn;
	
	@Column(name="modified_by", length=11)
	private Number createdBy;
	
	@Column(name="modified_on")
	private Date modifiedOn;
	
	@Column(name="delete_by", length=11)
	private Number deleteBy;
	
	@Column(name="delete_on")
	private Date deleteOn;
	
	@Column(name="is_delete", nullable=false, columnDefinition="default boolean false")
	private boolean isDelete;
}
