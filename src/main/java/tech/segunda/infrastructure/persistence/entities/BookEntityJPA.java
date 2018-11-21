package tech.segunda.infrastructure.persistence.entities;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Audited
@SequenceGenerator(name = "seq_books", sequenceName = "seq_books", allocationSize = 1)
@Table(name = "books")
public class BookEntityJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_books")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "inserted_by", length = 50, nullable = false, updatable = false)
    @Size(min = 6, max = 50)
    private String insertedBy;

    @Column(length = 13, nullable = false, unique=true, updatable = false)
    @Size(min = 13, max=13)
    private String isbn;

    @Column(length = 256, nullable = false)
    private String title;

    @Column(length = 1024)
    private String description;

    public BookEntityJPA() {
        // JPA
    }

    @PrePersist
    private void onCreate() {
        createdAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String titulo) {
		this.title = titulo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}