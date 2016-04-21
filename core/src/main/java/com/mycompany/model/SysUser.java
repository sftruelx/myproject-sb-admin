package com.mycompany.model;


import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

/**
 * �û�ʵ��
 *
 * @author william
 */

@Entity
@Table(name = "sys_user")
@Indexed
@XmlRootElement
public class SysUser extends BaseObject implements Serializable, UserDetails  {

    private Long id;
    private String usrName;
    private String usrPassword;
    private Integer usrFlag = 1;

    private SysRole sysRole;
    private boolean enabled = Boolean.TRUE.booleanValue();
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;

    private Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @OneToOne
    @JoinColumn(name = "usr_role_id", insertable = true, unique = true)
    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }
    @Column(name = "usr_name", nullable = false)
    @Field
    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
    @Column(name = "usr_password", nullable = false)
    @Field
    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    @Transient
    public String getUsername() {
        return usrName;
    }

    public void setUsername(String usrName) {
        this.usrName = usrName;
    }

    @Transient
    public String getPassword() {
        return usrPassword;
    }

    public void setPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    @Column(name = "usr_flag", nullable = false)
    @Field
    public Integer getUsrFlag() {
        return usrFlag;
    }

    public void setUsrFlag(Integer usrFlag) {
        this.usrFlag = usrFlag;
    }
    @Transient
    public boolean isEnabled() {
        return Boolean.TRUE;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Transient
    public boolean isAccountExpired() {
        return accountExpired;
    }
    @Transient
    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }
    @Transient
    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    /**
     * @return GrantedAuthority[] an array of roles.
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("getAuthorities   -- "+authorities);
        return this.authorities;
    }
    @Transient
    public void setAuthorities(
            Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }


    public void setAccountNonLocked(boolean accountLocked) {

    }

    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }
    public void setAccountNonExpired(boolean accountExpired) {

    }


    public void setAccountExpired(boolean accountExpired) {

    }

    /**
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     * @return true if credentials haven't expired
     */
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysUser)) {
            return false;
        }

        final SysUser sysUser = (SysUser) o;

        return !(usrName != null ? !usrName.equals(sysUser.usrName) : sysUser.usrName != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (usrName != null ? usrName.hashCode() : 0);
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.usrName)
                .toString();
    }

}
