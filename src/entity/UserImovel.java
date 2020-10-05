package entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user_imovel")
@Access(AccessType.FIELD)
@NamedQueries(
    {
    	@NamedQuery(
	    	name = UserImovel.IMOVEL_FAVORITO_POR_ID,
	    	query = "SELECT ui FROM UserImovel ui "
	    			+ "WHERE ui.user.id = ?1 "
	    			+ "and ui.imovel.id = ?2"
	    			+ "and ui.tipo = 2"),  // TODO enumerar os tipos.
    }
)
public class UserImovel {
	
	public static final String IMOVEL_FAVORITO_POR_ID = "ImovelFavoritoPorId";
	
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    User user;
    
    @ManyToOne
    @JoinColumn(name = "IMOVEL_ID")
    Imovel imovel;

	@Column(name = "TIPO", nullable = false, length = 70)
    private int tipo;
    
    @Column(name = "COMENTARIO", nullable = false, length = 70)
    private String comentario;
    
    @Column(name="IS_ACTIVE")
    private Boolean active;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
