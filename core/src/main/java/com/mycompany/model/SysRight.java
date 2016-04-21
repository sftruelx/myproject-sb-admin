package com.mycompany.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "sys_right")
@Indexed
@XmlRootElement
public class SysRight extends BaseObject implements Serializable {

	private Long id;

	private String rightText;

	private String rightUrl;

	private Long parent_id;

	private SysRight parent;

	private Set<SysRight> children = new HashSet<SysRight>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@DocumentId
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "right_text",nullable = false, unique = true)
	@Field
	public String getRightText() {
		return rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
	}

	@Column(name = "right_url",nullable = false, unique = true)
	@Field
	public String getRightUrl() {
		return rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	@Column(name = "parent_id")
	@Field
	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}



	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(
			name = "sys_role_right",
			joinColumns = { @JoinColumn(name = "right_id") },
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	public Set<SysRight> getChildren() {
		return children;
	}

	public void setChildren(Set<SysRight> children) {
		this.children = children;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SysRight)) {
			return false;
		}

		final SysRight sysRight = (SysRight) o;

		return !(rightText != null ? !rightText.equals(sysRight.rightText) : sysRight.rightText != null);

	}

	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		return (rightText != null ? rightText.hashCode() : 0);
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
				.append(this.rightText)
				.append(this.rightUrl)
				.toString();
	}
}
